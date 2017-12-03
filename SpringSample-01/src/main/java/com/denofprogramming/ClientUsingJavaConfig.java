package com.denofprogramming;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.denofprogramming.config.AppConfig;
import com.denofprogramming.service.MessagePrinter;
import com.denofprogramming.service.audit.AuditLog;
import com.denofprogramming.service.audit.Counter;

public class ClientUsingJavaConfig {

	public static void main(final String[] args) {

		AnnotationConfigApplicationContext context;
		// configuration part
		try {
			context = new AnnotationConfigApplicationContext(AppConfig.class);
			context.registerShutdownHook();

			final MessagePrinter printer = context.getBean("mockMessagePrinter",MessagePrinter.class);

			// doing something part...
			context.start();
			
			printer.printMessage();
			
			printer.printAndReturnMessage();
			printer.printAndReturnMessage();
			printer.printAndReturnMessage();

			printer.printMessage("test", 10.0);
			printer.myTest();

			((AuditLog) printer).output();
			System.out.println("Print methods called: " + ((Counter) printer).getCount() + " times!!");

			context.stop();

		} catch (final Exception ex) {
			ex.printStackTrace();
		}
	}
}
