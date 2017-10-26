package com.jamal.springdemo.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService implements GenericWelcomeService{

	@Override
	public List<String> getWelcomeMessage(String name) {
		List<String> myWelcomeMessage = new ArrayList<>();

		myWelcomeMessage.add("Hello! ");
		myWelcomeMessage.add(name);
		myWelcomeMessage.add(", Welcome to the spring cours :-");

		return myWelcomeMessage;
	}
}
