package com.pluralsight.controller;

import java.security.Principal;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	private Logger logger = Logger.getLogger(getClass().getName());
	
	@GetMapping("/")
	public String index(Principal principal) {
		// Get authenticated user name from Principal
		logger.info("authenticated user name from Principal : " + principal.getName());
		
		return "index";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(ModelMap model) {
		System.out.println("In the login method");
		
		return "login";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    
	    //You can redirect wherever you want, but generally it's a good practice to show login screen again.
	    return "redirect:/login?logout";
	}
	
	@RequestMapping(value="/access-denied", method=RequestMethod.GET)
	public String accessDenied(ModelMap model) {
		return "access-denied";
	}
	
}
