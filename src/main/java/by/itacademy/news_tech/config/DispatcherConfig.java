package by.itacademy.news_tech.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.lang.NonNull;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "by.itacademy.news_tech")
@PropertySource("classpath:sql.properties")
public class DispatcherConfig implements WebMvcConfigurer {

	/* private final ApplicationContext applicationContext;
	 * 
	 * @Autowired public DispatcherConfig(ApplicationContext applicationContex) {
	 * 
	 * this.applicationContext = applicationContex; }
	 */
	
	private static final String PREFIX = "/WEB-INF/view/";
	private static final String SUFFIX = ".jsp";

	private static final String RESOURCES_HANDLERS = "/resources/**";
	private static final String CLP_HANDLERS = "classpath:/resources/";

	@NonNull
	@Value("${jdbc.driver}")
	private String driver;

	@NonNull
	@Value("${jdbc.url}")
	private String url;

	@NonNull
	@Value("${jdbc.user}")
	private String user;

	@NonNull
	@Value("${jdbc.password}")
	private String password;

	@Value("${connection.pool.initialPoolSize:5}")
	private int initialPoolSize;

	@Value("${connection.pool.minPoolSize:5}")
	private int minPoolSize;

	@Value("${connection.pool.maxPoolSize:20}")
	private int maxPoolSize;

	@Value("${connection.pool.maxIdleTime:3000}")
	private int maxIdleTime;

	@NonNull
	@Value("${hibernate.packagesToScan}")
	private String packagesToScan;

	@Bean
	public DataSource dataSource() {

		ComboPooledDataSource pooledDataSource = new ComboPooledDataSource();

		try {
			
			pooledDataSource.setDriverClass(driver);
			
		} catch (PropertyVetoException e) {

			throw new RuntimeException(e);
		}
		
		pooledDataSource.setJdbcUrl(url);
		pooledDataSource.setUser(user);
		pooledDataSource.setPassword(password);

		pooledDataSource.setInitialPoolSize(initialPoolSize);
		pooledDataSource.setMinPoolSize(minPoolSize);
		pooledDataSource.setMaxPoolSize(maxPoolSize);
		pooledDataSource.setMaxIdleTime(maxIdleTime);

		return pooledDataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {

		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(packagesToScan);

		return sessionFactory;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager() {

		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory().getObject());

		return txManager;
	}

	// EndHibernateInit

	@Bean
	public ViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		//viewResolver.setApplicationContext(applicationContext);

		viewResolver.setPrefix(PREFIX);
		viewResolver.setSuffix(SUFFIX);

		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		if (!registry.hasMappingForPattern(RESOURCES_HANDLERS)) {

			registry.addResourceHandler(RESOURCES_HANDLERS).addResourceLocations(CLP_HANDLERS);
		}
	}
}
