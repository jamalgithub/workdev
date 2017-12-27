package com.jamal.springboot.springbootin10steps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages= {"com.jamal.springboot.springbootin10steps"})
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan("com.jamal.springboot.springbootin10steps")
public class SpringbootIn10StepsApplication {

	public static void main(String[] args) {
		//ApplicationContext applicationContext = 
				SpringApplication.run(SpringbootIn10StepsApplication.class, args);
		
		/*for (String name : applicationContext.getBeanDefinitionNames()) {
			System.out.println(name);
		}*/
	}
}
