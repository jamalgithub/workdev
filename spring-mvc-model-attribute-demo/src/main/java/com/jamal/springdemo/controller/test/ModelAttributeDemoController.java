package com.jamal.springdemo.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jamal.springdemo.domain.Address;

@Controller
public class ModelAttributeDemoController {
	private static Logger LOGGER = LoggerFactory.getLogger(ModelAttributeDemoController.class);
	
	/*
	 * Test Series of home version
	 * http://localhost:8080/spring-mvc-model-attribute-demo/homei  with i = , 2, 3, 4, 5
	 */
	
	/**
	 * version 1 of our home() method<br>
	 * url : http://localhost:8080/spring-mvc-model-attribute-demo/home
	 * @return View name
	 */
	@RequestMapping(value = "/home")
	public String home() {
		LOGGER.info("INSIDE home: " + System.currentTimeMillis());
		
		return "modelAttributeHome";
	}
	
	/**
	 *  version 2 of our home() method<br>
	 * url : http://localhost:8080/spring-mvc-model-attribute-demo/home2
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/home2")
	public ModelAndView home2() {
		LOGGER.info("INSIDE home2: " + System.currentTimeMillis());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("modelAttributeHome");
		mav.addObject("anAddress", new Address());
		//mav.addObject("command", new Address());
		
		return mav;
	}
	
	/**
	 * version 3 of our home() method<br>
	 * url : http://localhost:8080/spring-mvc-model-attribute-demo/home3
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/home3")
	public ModelAndView home3() {
		LOGGER.info("INSIDE home3: " + System.currentTimeMillis());
		
		ModelAndView mav = new ModelAndView("modelAttributeHome");
		mav.addObject("anAddress", new Address());
		//mav.addObject("command", new Address());
		
		return mav;
	}
	
	/**
	 * version 4 of our home() method<br>
	 * url : http://localhost:8080/spring-mvc-model-attribute-demo/home4
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/home4")
	public ModelAndView home4() {
		LOGGER.info("INSIDE home4: " + System.currentTimeMillis());
		
		return new ModelAndView("modelAttributeHome", "anAddress", new Address("Melbourne", "3000"));
		//return new ModelAndView("modelAttributeHome", "command", new Address("Melbourne", "3000"));
	}

	/**
	 * version 5 of our home() method<br>
	 * url : http://localhost:8080/spring-mvc-model-attribute-demo/home5
	 * @param model
	 * @return View name
	 */
	@RequestMapping(value = "/home5")
	public String home5(Model model) {
		LOGGER.info("INSIDE home5: " + System.currentTimeMillis());
		
		model.addAttribute("anAddress", new Address("Brisbane", "4000"));
		//model.addAttribute("command", new Address("Brisbane", "4000"));
		
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
		LOGGER.info("INSIDE modelAttributeTest1");
		
		model.addAttribute("testdata1A", "Welcome to the @ModelAttribute Test Bed!");
		model.addAttribute("testdata1B", "We will test both usages of the @ModelAttribute, on methods and on method arguments.");
	}
	
	/**
	 * Test 2: Demonstrating the usage of the <b>'name'</b> attribute of the @ModelAttribute annotation <b>(on a method)</b><br>
	 * add the returned value to a temporary Map object with a key <b>"testdata2"</b><br>
	 * The data from this Map would be added to the final Model after the execution of the handler method
	 * @return
	 */
	@ModelAttribute(name="testdata2")
	public String modelAttributeTest2() {
		LOGGER.info("INSIDE modelAttributeTest2");
		
		return "We will conduct a series of test here.";
	}
	
	/**
	 * Test 3: Demonstrating the usage of the @ModelAttribute annotation <b>(on a method)</b> to implicitly add an attribute by returning it and also demonstrating the usage of the <b>'value'</b> attribute of the @ModelAttribute annotation <b>(on a method)</b><br>
	 * add the returned value to a temporary Map object with a key <b>"testdata3"</b><br>
	 * The data from this Map would be added to the final Model after the execution of the handler method
	 * @return
	 */
	@ModelAttribute(value="testdata3")
	public Address modelAttributeTest3() {
		LOGGER.info("INSIDE modelAttributeTest3");
		
		return new Address("Jamal", "5000");
	}
	
	/**
	 * Test 4: Demonstrate the <b>default naming strategy</b> of the @ModelAttribute annotation <b>(on a method)</b><br>
	 * add the returned value to a temporary Map object with a key <b>"address"</b><br>
	 * The data from this Map would be added to the final Model after the execution of the handler method
	 * @return
	 */
	@ModelAttribute
	public Address modelAttributeTest4() {
		LOGGER.info("INSIDE modelAttributeTest4");
		
		return new Address("Sydney", "2000");
	}
	
	/**
	 * Test 5: testing the <b>@ModelAttribute</b> with 'value' and default binding<br>
	 * Before invoking this method, Spring tries to retrieve the object <b>"anAddress"</b> from the temporary Map object.<br>
	 * If it doesn’t find it in the Map, then it checks if there is a SessionAttributes annotation applied on the controller with the given value.<br>
	 * If the annotation is present, then the object is retrieved from the session.<br>
	 * If the session doesn’t contain the object despite of the @SessionAttributes, then an error is raised.
	 * @param anAddress
	 * @param model
	 * @return View name
	 */
	@RequestMapping(value="/test5", method=RequestMethod.POST)
	public String modelAttributeTest5(@ModelAttribute(value="anAddress") Address anAddress, ModelMap model) {
		LOGGER.info("INSIDE modelAttributeTest5");
		
		model.addAttribute("testdata5A", anAddress.getCity());
		model.addAttribute("testdata5B", anAddress.getZipCode());
		
		return "modelAttributeTest";
	}
	
	/**
	 * Test 6: Test to determine nature of how the <b>@ModelAttribute</b> (on method) and <b>@RequestMapping</b> work with no explicit logical view name.<br>
	 * Spring will determine <b>modelAttributeTest</b> as view name based on the mapped url <b>/modelAttributeTest</b><br>
	 * url : http://localhost:8080/spring-mvc-model-attribute-demo/modelAttributeTest
	 * @return
	 */
	@RequestMapping(value="/modelAttributeTest")
	@ModelAttribute("testdata6")
	public Address modelAttributeTest6() {
		LOGGER.info("INSIDE modelAttributeTest6");
		
		return new Address("Rabat", "10000");
	}
}