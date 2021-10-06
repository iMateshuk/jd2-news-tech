package by.itacademy.news_tech.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.lang.NonNull;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:sql.properties")
public class HibernateConfig {

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

}
