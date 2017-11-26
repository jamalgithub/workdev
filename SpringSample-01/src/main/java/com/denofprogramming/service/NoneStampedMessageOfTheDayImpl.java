package com.denofprogramming.service;

public final class NoneStampedMessageOfTheDayImpl extends AbstractStampedMessageOfTheDay {

	public NoneStampedMessageOfTheDayImpl() {
		super();
		System.out.println("no-arg Constructor called for " + NoneStampedMessageOfTheDayImpl.class.getName());
	}

	@Override
	public void init() {
		System.out.println("init() called for " + NoneStampedMessageOfTheDayImpl.class.getName());
	}

	@Override
	public void destroy() {
		System.out.println("destroy() called for " + NoneStampedMessageOfTheDayImpl.class.getName());
	}

	@Override
	public void setMessage(String message) {
		super.setMessage(message);
	}

}
