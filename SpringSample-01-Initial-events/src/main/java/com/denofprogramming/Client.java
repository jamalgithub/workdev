package com.denofprogramming;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.denofprogramming.service.MessagePrinter;

public class Client {

	public static void main(final String[] args) {

		// configuration part
		try {
			final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring/application.xml");
			context.registerShutdownHook();
			final MessagePrinter printer = context.getBean(MessagePrinter.class);

			// doing something part...
			context.start();
			printer.printMessage();
			context.stop();
			
		} catch (final Exception ex) {
			ex.printStackTrace();
		}

	}
}
