package com.denofprogramming.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.denofprogramming.service.event.MessagePrintedEvent;

//@Service("printer")
public final class MessagePrinter2 implements InitializingBean, DisposableBean {

	@Value("My printer service")
	private String name;

	@Value(">>")
	private String separator;

	// @Autowired
	// @Qualifier("timeStamped")
	// @Resource(name="timeStamped")
	@Inject()
	@Named("noneStamped")
	private MessageOfTheDayService service;

	@Autowired
	private ApplicationEventPublisher publisher;
	
	public MessagePrinter2() {
		System.out.println("no-arg Constructor called for " + MessagePrinter2.class.getName());
	}

	public MessagePrinter2(final String name, String separator, final MessageOfTheDayService service) {
		System.out.println("args Constructor called for " + MessagePrinter2.class.getName());
		this.name = name;
		this.separator = separator;
		this.service = service;
	}

	public void printMessage() {
		String message = "";
		if (service != null) {
			final StringBuilder sb = new StringBuilder(name);
			sb.append(this.separator);
			sb.append(service.getMessage());
			message = sb.toString();
			System.out.println(sb);
			//raise our event here
			//by default spring events are synchronous � the printMessage() method blocks until all listeners finish processing the event.
			publisher.publishEvent(new MessagePrintedEvent(this, message));
		} else {
			message = "No message printer...";
			System.out.println(message);
		}
	}
	
	public void printMessage(String dummy, double dbl) {
		System.out.println("test1");
	}
	
	public String myTest() {
		return "myTestResult";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public MessageOfTheDayService getService() {
		return service;
	}

	public void setService(MessageOfTheDayService service) {
		this.service = service;
	}

	public void init() {
		System.out.println("init called on MessagePrinterImpl");

	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Destroy called on MessagePrinterImpl");

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("After property set called in MessagePrinterImpl");

	}

}
