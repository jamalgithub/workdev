package com.jamal.springdemo.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {
	private static Logger LOGGER = LoggerFactory.getLogger(ErrorController.class);
	
	@RequestMapping(value = "/errors", method = RequestMethod.GET)
	public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {
		LOGGER.info("INSIDE renderErrorPage");
		
		ModelAndView errorPage = new ModelAndView("errorPage");
		String errorMsg = "";
		int httpErrorCode = (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
		
		switch (httpErrorCode) {
			case 400: {
				errorMsg = "Http Error Code: 400. Bad Request";
				break;
			}
			case 401: {
				errorMsg = "Http Error Code: 401. Unauthorized";
				break;
			}
			case 404: {
				errorMsg = "Http Error Code: 404. Resource not found";
				break;
			}
			case 500: {
				errorMsg = "Http Error Code: 500. Internal Server Error";
				break;
			}
		}
		
		errorPage.addObject("errorMsg", errorMsg);
		return errorPage;
	}	
	
	@RequestMapping(value = "/500Error", method = RequestMethod.GET)
	public void throwRuntimeException() {
		LOGGER.info("INSIDE throwRuntimeException");
		
	    throw new NullPointerException("Throwing a null pointer exception");
	}
}
