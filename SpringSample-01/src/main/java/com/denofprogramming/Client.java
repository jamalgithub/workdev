package com.denofprogramming;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.denofprogramming.service.MessagePrinter;

public class Client {	

	public static void main(final String[] args) {

		ClassPathXmlApplicationContext context;
		//configuration part
		try{
			context = new ClassPathXmlApplicationContext("/spring/application.xml");
			context.registerShutdownHook();						
			MessagePrinter printer = context.getBean(MessagePrinter.class);
			
			context.start();
			printer.printMessage();
			context.stop();
			
		}catch(final Exception ex){
			ex.printStackTrace();
		}
		

	}
}
