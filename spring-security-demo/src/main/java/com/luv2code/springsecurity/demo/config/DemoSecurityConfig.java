package com.luv2code.springsecurity.demo.config;

import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.User.UserBuilder;
//import org.springframework.security.core.GrantedAuthority;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	private Logger logger = Logger.getLogger(getClass().getName());
	
	// add a reference to our security data source
	@Autowired
	private DataSource securityDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// add our users for in memory authentication

		/*
		UserBuilder users = User.withDefaultPasswordEncoder();

		auth.inMemoryAuthentication().withUser(users.username("john").password("test123").roles("EMPLOYEE"))
				.withUser(users.username("mary").password("test123").roles("EMPLOYEE", "MANAGER"))
				.withUser(users.username("susan").password("test123").roles("EMPLOYEE", "ADMIN"));
		*/
		
		// use jdbc authentication!!!
		
		auth.jdbcAuthentication().dataSource(securityDataSource)
		//.usersByUsernameQuery("select user_id, pw, active from members where user_id=?")
		//.authoritiesByUsernameQuery("select user_id, role from roles where user_id=?")
		;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/webjars/**").permitAll()
			.antMatchers("/").hasRole("EMPLOYEE")
			.antMatchers("/leaders/**").hasRole("MANAGER")
			.antMatchers("/systems/**").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser") // Specifies the URL,which is used in action attribute on the <from> tag
				//.usernameParameter("username") // Username parameter, used in name attribute of the <input> tag. Default is 'username'.
				//.passwordParameter("password") // Password parameter, used in name attribute of the <input> tag. Default is 'password'.
				/*.successHandler((req, res, auth)->{  //Success handler invoked after successful authentication
					for (GrantedAuthority authority : auth.getAuthorities()) {
						logger.info("Role : " + authority.getAuthority());
					}
					logger.info("Login : " + auth.getName());
					res.sendRedirect(req.getContextPath()+"/"); // Redirect user to index page
				})*/
				.permitAll()
			.and()
			.logout()
				// .logoutUrl("/logout")
				// .logoutSuccessUrl("/login?logout")
				.permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
	}

}