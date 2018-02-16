package com.spring.security;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private BasicDataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("sunil").password("pass123").roles("USER")
			.and()
			.withUser("admin").password("pass123").roles("ADMIN");
		
		//auth.jdbcAuthentication().dataSource(dataSource)
        //.usersByUsernameQuery("select username, password, enabled" + " from users where username=?")
        //.authoritiesByUsernameQuery("select username, authority " + "from authorities where username=?")
		//;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			//.authorizeRequests().anyRequest().authenticated()
			.authorizeRequests().antMatchers("/").permitAll()
			//.and()
			//.authorizeRequests().antMatchers("/login**").permitAll()
			.and()
			.authorizeRequests().antMatchers("/user**").hasRole("USER")
			.and()
			.authorizeRequests().antMatchers("/admin**").hasRole("ADMIN")
			.and()
			.formLogin()
				.loginPage("/login") // Specifies the login page URL
				.permitAll()
				.loginProcessingUrl("/signin") // Specifies the URL,which is used in action attribute on the <from> tag
				.usernameParameter("userid")  // Username parameter, used in name attribute of the <input> tag. Default is 'username'.
				.passwordParameter("passwd")  // Password parameter, used in name attribute of the <input> tag. Default is 'password'.
				.successHandler((req, res, auth)->{  //Success handler invoked after successful authentication
					for (GrantedAuthority authority : auth.getAuthorities()) {
						System.out.println(authority.getAuthority());
					}
					System.out.println(auth.getName());
					res.sendRedirect(req.getContextPath()+"/"); // Redirect user to index page
				})
				//.defaultSuccessUrl("/") // URL, where user will go after authenticating successfully. Skipped if successHandler() is used.
				.failureHandler((req, res, exp)->{ // Failure handler invoked after authentication failure
					String errMsg="";
					if(exp.getClass().isAssignableFrom(BadCredentialsException.class)){
						errMsg="Invalid username or password.";
					}else{
						errMsg="Unknown error - "+exp.getMessage();
					}
					req.getSession().setAttribute("message", errMsg);			
					res.sendRedirect(req.getContextPath()+"/login"); // Redirect user to login page with error message.
				})
				//.failureUrl("/login?error") // URL, where user will go after authentication failure. Skipped if failureHandler() is used.
				//.permitAll() // Allow access to any URL associate to formLogin()
			.and()
			.logout()
				//.logoutUrl("/signout")  // Specifies the logout URL, default URL is '/logout'
				/*.logoutSuccessHandler((req,res,auth)->{  // Logout handler called after successful logout 
					req.getSession().setAttribute("message", "You are logged out successfully.");
					res.sendRedirect("/login"); // Redirect user to login page with message.
				})*/
				//.logoutSuccessUrl("/login") // URL, where user will be redirect after successful logout. Ignored if logoutSuccessHandler() is used.
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.and()
			.csrf().disable(); // Disable CSRF support;
   }
}
