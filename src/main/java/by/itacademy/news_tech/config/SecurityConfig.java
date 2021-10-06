package by.itacademy.news_tech.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	/*
	 * @Autowired private DataSource dataSource;
	 */
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("qwer").password("{noop}qwer").roles("user");
		auth.inMemoryAuthentication().withUser("asdf").password("{noop}asdf").roles("user","editor");
		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("user","admin");
		//auth.jdbcAuthentication().dataSource(dataSource);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/", "/readNews/**").hasRole("user")
			.antMatchers("/showFormForAdd/**", "/saveNews/**", "/showFormForUpdate/**").hasRole("editor")
			.antMatchers("/newsDelete/**").hasRole("admin")
			.and()
			.formLogin()
				.loginPage("/showLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
			.and()
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
		
	}

}
