package com.jamal.springdemo.service.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrganizationRegistrationService {
	
	@Value("#{serviceLengthOptions}")
	private Map<String, String> serviceLengthList;
	
	public Map<String, String> populateTurnover() {
		Map<String, String> turnover = new LinkedHashMap<String, String>();
		turnover.put("none", "-----SELECT-----");
		turnover.put("1000",  "Less than $1,000");
		turnover.put("10000",  "Greater than $1,000 but less than $10,000");
		turnover.put("100000",  "Greater than $10,000 but less than $100,000");
		return turnover;
	}
	
	public Map<String, String> populateTypes() {
		Map<String, String> types = new LinkedHashMap<String, String>();
		types.put("gov",  "Government");
		types.put("semigov",  "Semi Government");
		types.put("private",  "Private");
		return types;		
	}
	
	public Map<String, String> populateServiceLengths() {
		return new TreeMap<String, String>(serviceLengthList);
	}
	
}