package com.denofprogramming.service;

public abstract class AbstractStampedMessageOfTheDay implements MessageOfTheDayService {

	private String message = "hello world";

	public AbstractStampedMessageOfTheDay() {
		System.out.println("no-arg Constructor called for " + AbstractStampedMessageOfTheDay.class.getName());
	}

	public abstract void init();

	public abstract void destroy();

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
