package com.denofprogramming;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.denofprogramming.service.MessagePrinter;
import com.denofprogramming.service.audit.AuditLog;
import com.denofprogramming.service.audit.Counter;

public class Client {	

	public static void main(final String[] args) {

		ClassPathXmlApplicationContext context;
		//configuration part
		try{
			context = new ClassPathXmlApplicationContext("/spring/application.xml");
			context.registerShutdownHook();						
			//MessagePrinter printer = context.getBean(MessagePrinter.class);
			MessagePrinter printer = (MessagePrinter) context.getBean("liveMessagePrinter");
			
			context.start();
			
			printer.printAndReturnMessage();
			printer.printAndReturnMessage();
			printer.printAndReturnMessage();
			
			printer.printMessage();
			printer.printMessage("test", 10.0);
			printer.myTest();
			
			((AuditLog)printer).output();
			System.out.println("Print methods called: " + ((Counter)printer).getCount() + " times!!");
			
			context.stop();
			
		}catch(final Exception ex){
			ex.printStackTrace();
		}
		
	}
}
