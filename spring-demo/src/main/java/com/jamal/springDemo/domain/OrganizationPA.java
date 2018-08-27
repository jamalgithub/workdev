package com.jamal.springDemo.domain;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.jamal.springDemo.service.BusinessService;

@Component("myorg")
public class OrganizationPA {

	@Value("${nameOfCompany}")
	private String companyName;

	@Value("${startUpYear}")
	private int yearOfIncorporation;

	@Value("${postalCode}")
	private String postalCode;

	@Value("${empCount:22222}")
	private int employeeCount;

	@Value("${corporateSlogan:We build world class software!}")
	private String slogan;

	private String missionStatement;

	@Autowired
	private Environment env;

	private BusinessService businessService;

	public OrganizationPA() {
		System.out.println("default constructor called");
	}

	public OrganizationPA(String companyName, int yearOfIncorporation) {
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfIncorporation;
		System.out.println("constructor called");
	}

	public String corporateSlogan() {
		missionStatement = env.getProperty("statement");
		return missionStatement + " and also " + slogan;
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("organization: postConstruct called...............");
	}

	@PreDestroy
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

	public void setSlogan(String slogan) {
		this.slogan = slogan;
		System.out.println("setSlogan called");

	}

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
		System.out.println("setBusinessService called");

	}

	public String corporateService() {
		return businessService.offerService(companyName);
	}

	@Override
	public String toString() {
		return "OrganizationPA [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation
				+ ", postalCode=" + postalCode + ", employeeCount=" + employeeCount + "]";
	}

}
