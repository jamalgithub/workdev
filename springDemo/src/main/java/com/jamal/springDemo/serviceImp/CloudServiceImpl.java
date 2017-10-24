package com.jamal.springDemo.serviceImp;

import java.util.Random;

import com.jamal.springDemo.service.BusinessService;

public class CloudServiceImpl implements BusinessService {

	@Override
	public String offerService(String companyName) {
		Random random = new Random();
		String service = "\nAs Organisation, " + companyName + " offers world class Cloud computing infrastructure." + 
						"\nThe annual income exceeds " + random.nextInt(revenue) + " dollars.";
		return service;
	}

	public void postConstruct() {
		System.out.println("cloudService: postConstruct called ...........");
	}
	
	public void preDestroy() {
		System.out.println("cloudService: preDestroy called ............");
	}
}
