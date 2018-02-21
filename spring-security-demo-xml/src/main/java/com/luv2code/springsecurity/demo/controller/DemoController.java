package com.luv2code.springsecurity.demo.controller;

import java.security.Principal;
import java.util.logging.Logger;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@GetMapping("/")
	public String showHome(Principal principal) {
		// Get authenticated user name from Principal
		logger.info("authenticated user name from Principal : " + principal.getName());
		
		return "home";
	}

	@GetMapping("/leaders")
	public String showLeaders() {
		// Get authenticated user name from SecurityContext
	    SecurityContext context = SecurityContextHolder.getContext();
	    logger.info("authenticated user name from SecurityContext : " + context.getAuthentication().getName());
	    
		return "leaders";
	}

	@GetMapping("/systems")
	public String showSystems() {

		return "systems";
	}
}