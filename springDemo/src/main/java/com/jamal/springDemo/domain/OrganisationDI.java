package com.jamal.springDemo.domain;

public class OrganisationDI {

	private String companyName;
	private int yearOfIncorporation;
	private String postalCode;
	private int employeeCount;
	private String slogan;
	
	public OrganisationDI() {
		System.out.println("OrganisationDI: default constructor called");
	}

	public OrganisationDI(String companyName, int yearOfIncorporation) {
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfIncorporation;
		System.out.println("OrganisationDI: constructor called");
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		System.out.println("OrganisationDI: setPostalCode called");
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
		System.out.println("OrganisationDI: setEmployeeCount called");
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
		System.out.println("OrganisationDI: setSlogan called");
	}

	public String corporateSlogan() {		
		return slogan;
	}
	
	@Override
	public String toString() {
		return "Organisation [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation
				+ ", postalCode=" + postalCode + ", employeeCount=" + employeeCount + ", slogan=" + slogan + "]";
	}
}
