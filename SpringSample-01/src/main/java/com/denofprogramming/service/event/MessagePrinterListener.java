package com.denofprogramming.service.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinterListener implements ApplicationListener<MessagePrintedEvent> {

	public void onApplicationEvent(MessagePrintedEvent event) {

		System.out.println("MessagePrinterListener " + " received MessagePrintedEvent - start");
		try {
			Thread.sleep(3000);
			System.out.println(">>>>>" + event);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("MessagePrinterListener " + " received MessagePrintedEvent - done");
	}

}
