package com.jamal.springDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jamal.springDemo.domain.OrganizationPX;

public class PropertiesWithXmlApp {

	public static void main(String[] args) {
		// create the application context (container)
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-px.xml");
		
		OrganizationPX org = (OrganizationPX) ctx.getBean("myorg");
		System.out.println(org);
		
		// close the application context (container)
		((ClassPathXmlApplicationContext) ctx).close();
	}

}
