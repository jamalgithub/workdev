package com.denofprogramming.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.denofprogramming.service.BasicMessageOfTheDayImpl;
import com.denofprogramming.service.MessageOfTheDayService;

@Configuration
public class ServiceConfig {

	@Bean(name="service")
	// @Scope("prototype")
	public MessageOfTheDayService messageOfTheDay() {
		return new BasicMessageOfTheDayImpl();
	}
}
