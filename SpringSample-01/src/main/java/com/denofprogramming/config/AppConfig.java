package com.denofprogramming.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.denofprogramming.service.MessagePrinter;
import com.denofprogramming.service.MockMessagePrinterImpl;
import com.denofprogramming.service.config.MessageValueConfig;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.denofprogramming.service")
@Import({MessagePrinterConfig.class, ServiceConfig.class})
//@Import({MessagePrinterConfig.class, ServiceConfig.class, MessageValueConfig.class})
//@ImportResource("/spring/application2.xml")
public class AppConfig {

	@Inject
	private MessageValueConfig messageValueConfig;
	
	@Bean
	public MessagePrinter mockMessagePrinter() {
		return new MockMessagePrinterImpl();
	}

	/*
	 * @Bean public MessagePrinter mockMessagePrinter2() { return new
	 * MockMessagePrinterImpl(); }
	 */	
}
