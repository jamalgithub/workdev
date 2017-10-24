package com.jamal.springmvcdemo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jamal.service.RandomizerRequestScope;
import com.jamal.service.RandomizerSessionScope;

@Controller
public class ScopeController {

	@Autowired
	RandomizerRequestScope randomizerRequestScope;
	
	@Autowired
	RandomizerSessionScope randomizerSessionScope;
	
	@RequestMapping("/scope")
	public void getRandom(HttpServletResponse response) throws Exception{
		response.getWriter().write("***************** request scope **************** <br>");
		response.getWriter().write("Old number: " + randomizerRequestScope.getRandomNumber() + "<br>");
		randomizerRequestScope.generateRandomNumber();
		response.getWriter().write("New number: " + randomizerRequestScope.getRandomNumber() + "<br>");
		response.getWriter().write("Object reference: " + randomizerRequestScope + "<br>");
		
		response.getWriter().write("***************** session scope **************** <br>");
		response.getWriter().write("Old number: " + randomizerSessionScope.getRandomNumber() + "<br>");
		randomizerSessionScope.generateRandomNumber();
		response.getWriter().write("New number: " + randomizerSessionScope.getRandomNumber() + "<br>");
		response.getWriter().write("Object reference: " + randomizerRequestScope + "<br>");
	}
}
