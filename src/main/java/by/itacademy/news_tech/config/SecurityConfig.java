package by.itacademy.news_tech.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired 
	private DataSource dataSource;
	 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		/*
		 * auth.inMemoryAuthentication().withUser("qwer").password("{noop}qwer").roles(
		 * "USER");
		 * auth.inMemoryAuthentication().withUser("asdf").password("{noop}asdf").roles(
		 * "USER","EDITOR");
		 * auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles
		 * ("USER","ADMIN");
		 */
		 
		auth.jdbcAuthentication().dataSource(dataSource);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/", "/readNews/**").hasRole("USER")
			.antMatchers("/showFormForAdd/**", "/saveNews/**", "/showFormForUpdate/**").hasRole("EDITOR")
			.antMatchers("/newsDelete/**").hasRole("ADMIN")
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
