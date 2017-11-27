package com.denofprogramming.service;

import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("timeStamped")
public final class TimeStampedMessageOfTheDayImpl extends AbstractStampedMessageOfTheDay {

	public TimeStampedMessageOfTheDayImpl() {
		super();
		System.out.println("no-arg Constructor called for " + TimeStampedMessageOfTheDayImpl.class.getName());
	}

	@Override
	public void init() {
		System.out.println("init() called for " + TimeStampedMessageOfTheDayImpl.class.getName());
	}

	@Override
	public void destroy() {
		System.out.println("destroy() called for " + TimeStampedMessageOfTheDayImpl.class.getName());
	}

	@Override
	public String getMessage() {
		final Date now = GregorianCalendar.getInstance().getTime();
		return now.toString() + ">>" + super.getMessage();
	}
	
	@Override
	@Value("Time Stamed Message!!")
	public void setMessage(String message) {
		super.setMessage(message);
	}

}
