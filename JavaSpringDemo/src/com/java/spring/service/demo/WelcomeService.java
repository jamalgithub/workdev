package com.java.spring.service.demo;

import java.util.ArrayList;
import java.util.List;

public class WelcomeService {
	public List<String> getWelcomeMessage(String name) {
		List<String> myWelcomeMessage = new ArrayList<>();
		
		myWelcomeMessage.add("Hello! ");
		myWelcomeMessage.add(name);
		myWelcomeMessage.add(", Welcome to the spring cours :-");
		
		return myWelcomeMessage;
	}
}
