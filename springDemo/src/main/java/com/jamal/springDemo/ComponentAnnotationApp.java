package com.jamal.springDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jamal.springDemo.domain.promotion.TradeFair;

public class ComponentAnnotationApp {

	public static void main(String[] args) {
		// create the application context (container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-ca.xml");
		
		TradeFair tradeFair = (TradeFair) ctx.getBean("myfair");
		System.out.println(tradeFair.specialPromotionalPricing());
		
		// close the application context (container)
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
