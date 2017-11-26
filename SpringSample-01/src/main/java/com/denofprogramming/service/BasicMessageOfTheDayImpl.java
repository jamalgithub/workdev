package com.denofprogramming.service;


public class BasicMessageOfTheDayImpl implements MessageOfTheDayService {

	private String message = "hello world";

	public BasicMessageOfTheDayImpl() {
		System.out.println("no-arg Constructor called for " + BasicMessageOfTheDayImpl.class.getName());
	}

	public void init() {
		System.out.println("init() called for " + BasicMessageOfTheDayImpl.class.getName());
	}

	public void destroy() {
		System.out.println("destroy() called for " + BasicMessageOfTheDayImpl.class.getName());
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
