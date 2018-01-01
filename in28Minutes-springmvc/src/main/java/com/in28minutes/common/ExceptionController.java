package com.in28minutes.common;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ControllerAdvice
@EnableWebMvc
public class ExceptionController {

	private Log logger = LogFactory.getLog(ExceptionController.class);

	@ExceptionHandler(value = RuntimeException.class)
	public String handleError(HttpServletRequest req, RuntimeException exception, Model model) {
		logger.error("Request: " + req.getRequestURL() + " raised " + exception);
		
		model.addAttribute("exception", exception);
		
		return "error_0";
	}
	
	//@ExceptionHandler(value = Exception.class)
	public ModelAndView handleError2(HttpServletRequest req, Exception exception) {
		logger.error("Request: " + req.getRequestURL() + " raised " + exception);
		
		ModelAndView model = new ModelAndView("error_0");
		model.addObject("exception", exception);
		
		return model;
	}
}