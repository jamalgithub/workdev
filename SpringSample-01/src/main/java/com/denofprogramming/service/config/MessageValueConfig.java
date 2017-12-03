package com.denofprogramming.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.denofprogramming.model.MessageValue;

@Configuration
public class MessageValueConfig {

	@Bean(name = "1")
	public MessageValue one() {
		return new MessageValue("Sunday messeage message!");
	}

	@Bean(name = "2")
	public MessageValue two() {
		return new MessageValue("Monday morning message!");
	}

	@Bean(name = "3")
	public MessageValue three() {
		return new MessageValue("Tuesday morning message!");
	}

	@Bean(name = "4")
	public MessageValue four() {
		return new MessageValue("Wednesday morning message!");
	}

	@Bean(name = "5")
	public MessageValue five() {
		return new MessageValue("Thursday morning message!");
	}

	@Bean(name = "6")
	public MessageValue six() {
		return new MessageValue("Friday morning message!");
	}

	@Bean(name = "7")
	public MessageValue seven() {
		return new MessageValue("Saturday morning message!");
	}

}
