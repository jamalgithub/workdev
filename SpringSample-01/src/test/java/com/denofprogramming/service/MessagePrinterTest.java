package com.denofprogramming.service;

import static org.junit.Assert.assertNotSame;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring/test-application.xml")
public class MessagePrinterTest {

	@Inject
	//@Named("liveMessagePrinter")
	@Named("mockMessagePrinter")
	private MessagePrinter messagePrinter;
	
	@Test
	public void testPrintAndReturnMessage() {
		final String result = messagePrinter.printAndReturnMessage();
		
		//Assert.assertTrue("Message should not be null", result != null);
		Assert.assertNotNull("Message should not be null", result);
		//Assert.assertTrue("Message should not be blank", !"".equals(result));		
		assertNotSame("Message should not be blank", "", result);		
	}
}
