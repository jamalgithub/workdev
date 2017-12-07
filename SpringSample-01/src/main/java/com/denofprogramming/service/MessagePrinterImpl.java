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

@Service("liveMessagePrinter")
public final class MessagePrinterImpl implements InitializingBean, DisposableBean, MessagePrinter {

	@Value("${messageprinter.name}")
	private String name;

	@Value("${messageprinter.separator}")
	private String separator;

	// @Autowired
	// @Qualifier("timeStamped")
	// @Resource(name="timeStamped")
	@Inject()
	//@Named("noneStamped")
	@Named("i18nDynamicMessageOfDay")
	private MessageOfTheDayService service;

	@Autowired
	private ApplicationEventPublisher publisher;
	
	public MessagePrinterImpl() {
		System.out.println("no-arg Constructor called for " + MessagePrinterImpl.class.getName());
	}

	public MessagePrinterImpl(final String name, String separator, final MessageOfTheDayService service) {
		System.out.println("args Constructor called for " + MessagePrinterImpl.class.getName());
		this.name = name;
		this.separator = separator;
		this.service = service;
	}

	/* (non-Javadoc)
	 * @see com.denofprogramming.service.MessagePrinter#printMessage()
	 */
	@Override
	public void printMessage() {
		printAndReturnMessage();
	}
	
	@Override
	public String printAndReturnMessage() {
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
		//throw new IllegalArgumentException("Exception test");
		
		return message;
	}
	
	/* (non-Javadoc)
	 * @see com.denofprogramming.service.MessagePrinter#printMessage(java.lang.String, double)
	 */
	@Override
	public void printMessage(String dummy, double dbl) {
		System.out.println("Dummy printMessage()");
	}
	
	/* (non-Javadoc)
	 * @see com.denofprogramming.service.MessagePrinter#myTest()
	 */
	@Override
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
