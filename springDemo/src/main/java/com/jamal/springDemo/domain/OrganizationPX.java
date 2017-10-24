package com.jamal.springDemo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.jamal.springDemo.service.BusinessService;

public class OrganizationPX {
	
	private String companyName;
	private int yearOfIncorporation;
	
	@Value("${org.postalCode}")
	private String postalCode;
	
	private int employeeCount;
	private String slogan;
	private BusinessService businessService;
	
	public OrganizationPX() {
		System.out.println("default constructor called");
	}
	
	public OrganizationPX(String companyName, int yearOfIncorporation) {
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfIncorporation;
		System.out.println("constructor called");
	}

//	public void initialize() {
//		System.out.println("organization: initialize method called");
//	}
//	
//	public void destroy() {
//		System.out.println("organization: destroy method called");
//
//	}
	
	public void postConstruct() {
		System.out.println("organization: postConstruct called...............");
	}
	
	public void preDestroy() {
		System.out.println("organization: preDestroy called...............");
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		System.out.println("setPostalCode called");

	}


	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
		System.out.println("setEmployeeCount called");

	}


	@Autowired
	public void setSlogan(@Value("${org.slogan}") String slogan) {
		this.slogan = slogan;
		System.out.println("setSlogan called");

	}


	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
		System.out.println("setBusinessService called");

	}


	public String corporateSlogan() {
		return slogan;
	}
	
	public String corporateService() {
		return businessService.offerService(companyName);
	}


	@Override
	public String toString() {
		return "Organization [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation
				+ ", postalCode=" + postalCode + ", employeeCount=" + employeeCount + ", slogan=" + slogan + "]";
	}

}
