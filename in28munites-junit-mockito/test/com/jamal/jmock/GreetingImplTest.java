package com.jamal.jmock;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GreetingImplTest {

	private Greeting greeting;

	@Before
	public void setup() {
		System.out.println("Setup");
		greeting = new GreetingImpl();
	}

	@After
	public void tearDown() {
		System.out.println("TearDown");
		greeting = null;
	}

	@Test
	public void greetShouldReturnValidOutput() {
		System.out.println("greetShouldReturnValidOutput");
		String result = greeting.greet("Junit");

		assertNotNull(result);
		assertEquals("Hello Junit", result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void agreeShouldThrowAnException_For_NameIsNull() {
		System.out.println("agreeShouldThrowAnException_For_NameIsNull");
		greeting.greet(null);
		// greeting.greet("aa");
	}

	@Test(expected = IllegalArgumentException.class)
	public void agreeShouldThrowAnException_For_NameIsBlank() {
		System.out.println("agreeShouldThrowAnException_For_NameIsBlank");
		greeting.greet("");
	}
}
