package com.jamal.springDemo.serviceImp;

import java.util.Random;

import com.jamal.springDemo.service.BusinessService;

public class EcommerceServiceImpl implements BusinessService {

	@Override
	public String offerService(String companyName) {
		Random random = new Random();
		String service = "\nAs Organisation, " + companyName + " provides an outstanding Ecommerce platform." + 
				"\nThe annual income exceeds " + random.nextInt(revenue) + " dollars.";
		return service;
	}

}
