package com.jamal.springdemo.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jamal.springdemo.domain.Address;

@Controller
public class ModelAttributeDemoController {
	private static Logger LOGGER = LoggerFactory.getLogger(ModelAttributeDemoController.class);
	
	@RequestMapping(value = "/home")
	public String home() {
		LOGGER.info("INSIDE home: " + System.currentTimeMillis());
		
		return "modelAttributeHome";
	}

	/*
	 * Test series to determine the nature of the @ModelAttribute annotation (on a method)
	 */
	
	/**
	 * Test 1: Demonstrating the usage of @ModelAttribute annotation <b>(on a method)</b> to add <b>multiple attributes</b>
	 * @param model
	 */
	@ModelAttribute
	public void modelAttributeTest1(Model model) {
		LOGGER.info("INSIDE modelAttributeTest1: " + System.currentTimeMillis());
		model.addAttribute("testdata1A", "Welcome to the @ModelAttribute Test Bed!");
		model.addAttribute("testdata1B", "We will test both usages of the @ModelAttribute, on methods and on method arguments.");
	}
	
	/**
	 * Test 2: Demonstrating the usage of the <b>'name'</b> attribute of the @ModelAttribute annotation <b>(on a method)</b>
	 * @return
	 */
	@ModelAttribute(name="testdata2")
	public String modelAttributeTest2() {
		LOGGER.info("INSIDE modelAttributeTest2");
		
		return "We will conduct a series of test here.";
	}
	
	/**
	 * Test 3: Demonstrating the usage of the @ModelAttribute annotation <b>(on a method)</b> to implicitly add an attribute by returning it and also demonstrating the usage of the <b>'value'</b> attribute of the @ModelAttribute annotation <b>(on a method)</b>
	 * @return
	 */
	@ModelAttribute(value="testdata3")
	public Address modelAttributeTest3() {
		LOGGER.info("INSIDE modelAttributeTest3");
		
		return new Address("Jamal", "5000");
	}
	
	/**
	 * Test 4: Demonstrate the <b>default naming strategy</b> of the @ModelAttribute annotation <b>(on a method)</b>
	 * @return
	 */
	@ModelAttribute
	public Address modelAttributeTest4() {
		LOGGER.info("INSIDE modelAttributeTest4");
		
		return new Address("Sydney", "2000");
	}
}