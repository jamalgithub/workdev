package com.tutorialspoint.junit;

import org.junit.Test;

import com.tutorialspoint.pojo.MessageUtil;

import static org.junit.Assert.assertEquals;

public class TestJunit {
	String message = "Robert";	
	MessageUtil messageUtil = new MessageUtil(message);
   
	@Test
	public void testPrintMessage() {
		System.out.println("Inside testPrintMessage()");    
		assertEquals(message, messageUtil.printMessage());    
    }	
	
	@Test
	public void testSalutationMessage() {
		System.out.println("Inside testSalutationMessage()");
		message = "Hi!" + message;
		assertEquals(message,messageUtil.salutationMessage());
	}
	
	@Test(timeout=1000)
	public void testPrintMessageLoop() {
		System.out.println("Inside testPrintMessageLoop()");     
		messageUtil.printMessageLoop();     
	}
	
	@Test(expected = ArithmeticException.class)
	public void testPrintMessageException() {
		System.out.println("Inside printMessageException()");     
		messageUtil.printMessageException();     
	}
}