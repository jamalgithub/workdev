package com.denofprogramming.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("noneStamped")
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
	@Value("None Stamed Message!!")
	public void setMessage(String message) {
		super.setMessage(message);
	}

}
