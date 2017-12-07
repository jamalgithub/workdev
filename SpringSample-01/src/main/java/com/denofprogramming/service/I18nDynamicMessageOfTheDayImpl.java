package com.denofprogramming.service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service("i18nDynamicMessageOfDay")
public class I18nDynamicMessageOfTheDayImpl implements MessageOfTheDayService {
	private static String KEY_PREFIX = "messageoftheday.";
	
	@Value("${i18nMessageofday.language}")
	private String language;
	
	@Value("${i18nMessageofday.country}")
	private String country;
	
	@Inject()
	private MessageSource messageSource;
	
	@Override
	public String getMessage() {
		//What day is it today??
		final int day = GregorianCalendar.getInstance().get(Calendar.DAY_OF_WEEK);
		
		final Locale locale = new Locale(language, country);
		
		final String result = messageSource.getMessage(KEY_PREFIX + day, null, locale);
		
		return result;
	}

}
