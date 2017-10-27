package com.jamal.springDemo.domain;

public class OrganisationCP {

	private String companyName;
	private int yearOfIncorporation;
	private Address address;		

	public OrganisationCP(String companyName, int yearOfIncorporation, Address address) {
		this.companyName = companyName;
		this.yearOfIncorporation = yearOfIncorporation;
		this.address = address;
	}
		
	@Override
	public String toString() {
		return "OrganisationCP [companyName=" + companyName + ", yearOfIncorporation=" + yearOfIncorporation
				+ ", address=" + address + "]";
	}
}
