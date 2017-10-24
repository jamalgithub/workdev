package com.jamal.springDemo.domain;

public class OrganisationAware {

	private String companyName;
	private int yearOfIncorporation;
	private String postalCode;
	private int employeeCount;
	
	public OrganisationAware() {
		System.out.println("OrganisationAware: default constructor called");
	}

	public OrganisationAware(String companyName, int yearOfIncorporation) {
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfIncorporation;
		System.out.println("OrganisationAware: constructor called");
	}
	
	public String getCompanyName() {
		return companyName;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
		System.out.println("OrganisationAware: setPostalCode called");
	}

	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
		System.out.println("OrganisationAware: setEmployeeCount called");
	}	

	@Override
	public String toString() {
		return "OrganisationAware [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation
				+ ", postalCode=" + postalCode + ", employeeCount=" + employeeCount + "]";
	}
}
