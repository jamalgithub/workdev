package com.in28minutes.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/math")
public class MathController {
	
    @RequestMapping(value = "/calculate", method = RequestMethod.GET)
    public ModelAndView calculateSum(@RequestParam int a, @RequestParam int b) {
        ModelAndView model = new ModelAndView("math-result");
         
        model.addObject("sum", (a + b));
        model.addObject("subtract", (a - b));
        model.addObject("multiply", (a * b));
        model.addObject("divide", (a / b));
         
        return model;
    }
    
    @ExceptionHandler(value = {ArithmeticException.class, IllegalArgumentException.class})
	public String handleException(HttpServletRequest request, Exception ex, Model model) {
		//logger.error("Request " + request.getRequestURL() + " Threw an Exception", ex);
		model.addAttribute("exception", ex);
		
		return "math-error";
	}
}