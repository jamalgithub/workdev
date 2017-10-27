package com.jamal.springDemo.domain;

import com.jamal.springDemo.service.BusinessService;

public class OrganisationCB {

	private String companyName;
	private int yearOfIncorporation;
	private String postalCode;
	private int employeeCount;
	private String slogan;
	private BusinessService businessService;
	
	public OrganisationCB() {
		System.out.println("OrganisationCB: default constructor called");
	}

	public OrganisationCB(String companyName, int yearOfIncorporation) {
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfIncorporation;
		System.out.println("OrganisationCB: constructor called");
	}

	public void initialize() {
		System.out.println("OrganisationCB: initialize method called..........................");
	}
	
	public void destroy() {
		System.out.println("OrganisationCB: destroy method called.............................");
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		System.out.println("OrganisationCB: setPostalCode called");
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
		System.out.println("OrganisationCB: setEmployeeCount called");
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
		System.out.println("OrganisationCB: setSlogan called");
	}

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
		System.out.println("OrganisationCB: setBusinessService called");
	}

	public String corporateSlogan() {		
		return slogan;
	}
	
	public String corporateService() {
		return businessService.offerService(companyName);
	}
	
	public static OrganisationCB createInstance(String companyName, int yearOfIncorporation) {
		System.out.println("OrganisationCB: Invoking the static factory method ...........");
		return new OrganisationCB(companyName, yearOfIncorporation);
	}		

	@Override
	public String toString() {
		return "OrganisationCB [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation
				+ ", postalCode=" + postalCode + ", employeeCount=" + employeeCount + "]";
	}
}
