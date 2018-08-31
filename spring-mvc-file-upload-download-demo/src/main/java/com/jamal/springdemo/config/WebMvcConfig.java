package com.jamal.springdemo.config;

import java.io.IOException;
import java.util.Locale;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.jamal.springdemo.interceptors.ExecutionTimerInterceptor;
import com.jamal.springdemo.interceptors.HeaderInterceptor;
import com.jamal.springdemo.interceptors.VisitorInterceptor;

@Configuration
@ComponentScan("com.jamal.springdemo")
@EnableWebMvc
@PropertySource(value = {"classpath:organization.properties", "classpath:test/config.properties"})
public class WebMvcConfig extends WebMvcConfigurerAdapter /* implements WebMvcConfigurer */ {

	@Autowired
	private HeaderInterceptor headerInterceptor;
	
	@Autowired
	private VisitorInterceptor visitorInterceptor;
	
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
	
	/*@Bean
	public SessionLocaleResolver localeResolver() {
	    SessionLocaleResolver localeResolver = new SessionLocaleResolver();
	    localeResolver.setDefaultLocale(Locale.ENGLISH);
	    return localeResolver;
	}*/
	
	@Bean
    public CookieLocaleResolver localeResolver(){
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setDefaultLocale(Locale.ENGLISH);
        localeResolver.setCookieName("my-locale-cookie");
        localeResolver.setCookieMaxAge(3600);
        return localeResolver;
    }
	
	/*@Bean
    public MessageSource messageSource () {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }*/
	
	@Bean
    public ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
	    LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
	    lci.setParamName("locale");
	    return lci;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public UrlBasedViewResolver urlBasedViewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	
	/*public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }*/
	
	@Bean(name = "multipartResolver")
    public CommonsMultipartResolver getResolver() throws IOException {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        // no limit
        resolver.setMaxUploadSize(-1);
        return resolver;
    }
	
	@Bean(name="serviceLengthOptions")
	public PropertiesFactoryBean mapper() {
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		bean.setLocation(new ClassPathResource("test/organization-values.properties"));
		return bean;
		
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("testMvcHome");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor()).addPathPatterns("/i18nL10nDemo/**");
		registry.addInterceptor(headerInterceptor);
		//registry.addInterceptor(new HeaderInterceptor());
		registry.addInterceptor(visitorInterceptor);
		registry.addInterceptor(executionTimerInterceptor).addPathPatterns("/location");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}	

}
