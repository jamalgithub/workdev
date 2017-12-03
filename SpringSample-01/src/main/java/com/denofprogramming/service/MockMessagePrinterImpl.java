package com.denofprogramming.service;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Named("mockMessagePrinter")
public final class MockMessagePrinterImpl implements MessagePrinter {

	@Autowired
	@Qualifier("timeStamped")
	private MessageOfTheDayService service;

	public MockMessagePrinterImpl() {
	}

	public MockMessagePrinterImpl(final MessageOfTheDayService service) {
		this.service = service;
	}

	@Override
	public void printMessage() {
		printAndReturnMessage();
	}

	@Override
	public String printAndReturnMessage() {
		String message = "mock ";
		if (service == null) {
			message += "No message available!!";
		} else {
			message += service.getMessage();
		}
		System.out.println(message);
		return message;
	}

	@Override
	public void printMessage(String dummy, double dbl) {
		System.out.println("mock printMessage with args");
	}

	@Override
	public String myTest() {
		return "mockMyTest";
	}

}
