package com.denofprogramming.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessagePrinter {

	@Value("My printer service attribute set")
	private String name;

	@Value(">>")
	private String separator;

	@Inject
	@Named(value = "dynamicMessageOfDay")
	private MessageOfTheDayService service;

	public void printMessage() {
		String message = "";
		if (service != null) {
			final StringBuilder sb = new StringBuilder(name);
			sb.append(this.separator);
			sb.append(service.getMessage());
			message = sb.toString();
			System.out.println(sb);
		} else {
			message = "No message printer...";
			System.out.println(message);
		}
	}

}
