package com.jamal.springdemo.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/i18nL10nDemo")
public class I18nL10nController {
	private static Logger LOGGER = LoggerFactory.getLogger(I18nL10nController.class);

	@Autowired
    private MessageSource messageSource;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {		
		String log = messageSource.getMessage("welcome.log", null, locale);
		
		//LOGGER.info("Welcome home! The client locale is {}.", locale);
		LOGGER.info(log, locale);
	
		// add parametrized message from controller
        String welcome = messageSource.getMessage("welcome.message", new Object[]{"Jamal Jij"}, locale);
        model.addAttribute("message", welcome);
        
        // obtain locale from LocaleContextHolder
        Locale currentLocale = LocaleContextHolder.getLocale();
        model.addAttribute("locale", currentLocale);

        model.addAttribute("startMeeting", "10:30");
        
		return "test/i18nTestViews/home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		LOGGER.info("Welcome login! The client locale is {}.", locale);
	
		return "test/i18nTestViews/login";
	}
}
