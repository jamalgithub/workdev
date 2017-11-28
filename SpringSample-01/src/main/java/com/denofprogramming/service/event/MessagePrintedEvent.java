package com.denofprogramming.service.event;

import org.springframework.context.ApplicationEvent;

public class MessagePrintedEvent extends ApplicationEvent {

	private String message;

	private static final long serialVersionUID = -950714771209950700L;	

	/**
	 * Create a new MessagePrintedEvent.
	 * @param source the object on which the event initially occurred (never {@code null})
	 */
	public MessagePrintedEvent(Object source) {
		super(source);
	}

	public MessagePrintedEvent(Object source, String message) {
		this(source);
		this.message = message;
	}
	
	/**
	 * @return A a String representation of this MessagePrintedEvent
	 */
	public String toString() {
		return "Message Printed Event raised with: (" + message + ")";
	}

}
