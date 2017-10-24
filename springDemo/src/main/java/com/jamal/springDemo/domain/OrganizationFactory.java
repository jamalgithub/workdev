package com.jamal.springDemo.domain;

public class OrganizationFactory {

	public OrganisationCB getInstance(String companyName, int yearOfIncorporation) {
		System.out.println("OrganizationFactory: Invoking instance Factory method ...........");
		return new OrganisationCB(companyName, yearOfIncorporation);
	}
}
