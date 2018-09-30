package com.jamal.springdemo.controller.test;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jamal.springdemo.domain.test.OrganizationRepresentative;

@Controller
@RequestMapping("/formValidationDemo")
public class FormValidationDemoController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(FormValidationDemoController.class);
	
	/*@Autowired
	Validator validator;*/
	
	@RequestMapping("/home")
	public ModelAndView home(Model model) {
		return new ModelAndView("test/formValidationTestViews/formValidationHome", "orgrep", new OrganizationRepresentative());
	}
	
	@RequestMapping(value="/registerOrgRep", method= RequestMethod.POST)
	public String organizationRepresentativeRegistration(@Valid @ModelAttribute("orgrep") OrganizationRepresentative orgRepresentative,
					BindingResult result, Model model) {
		// debug code
		if(result.hasErrors()) {
			model.addAttribute("formerrors", result.getAllErrors());
			List<FieldError> ferrList = result.getFieldErrors();
			for(FieldError ferr: ferrList) {
				LOGGER.info("field error: " + ferr.getDefaultMessage());
			}
			
			List<ObjectError> gerrFeList = result.getGlobalErrors();
			for(ObjectError gerr: gerrFeList) {
				LOGGER.info("global error: " + gerr.getDefaultMessage());
			}
			
			return "test/formValidationTestViews/formValidationHome";
		} else {
			return "test/formValidationTestViews/formValidationResult";
		}
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		//dataBinder.setValidator(validator);
	}

}