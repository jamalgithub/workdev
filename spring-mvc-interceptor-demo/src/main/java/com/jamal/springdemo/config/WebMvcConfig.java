package com.jamal.springdemo.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.jamal.springdemo.interceptors.ExecutionTimerInterceptor;
import com.jamal.springdemo.interceptors.HeaderInterceptor;

@Configuration
@ComponentScan("com.jamal.springdemo")
@EnableWebMvc
@PropertySource(value = {"classpath:organization.properties" })
public class WebMvcConfig extends WebMvcConfigurerAdapter /* implements WebMvcConfigurer */ {

	@Autowired
	private HeaderInterceptor headerInterceptor;
	
	@Autowired
	private ExecutionTimerInterceptor executionTimerInterceptor;
	
	@Autowired
	private Environment env;
	
	@Value("${jdbc.driverClassName}")
    protected String driverClassName;
	
	@Value("${jdbc.url}")
    private String url;
	
	@Bean(name="ds")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUsername(env.getProperty("jdbc.userName"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		return dataSource;
	}

	/*@Bean
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
		RequestMappingHandlerMapping rmhm = new RequestMappingHandlerMapping();
		rmhm.setUseSuffixPatternMatch(false);
		rmhm.setUseTrailingSlashMatch(false);
		return rmhm;
	}*/

	@Bean
	public UrlBasedViewResolver urlBasedViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(headerInterceptor);
		//registry.addInterceptor(new HeaderInterceptor());
		registry.addInterceptor(executionTimerInterceptor).addPathPatterns("/location");
	}	

}
