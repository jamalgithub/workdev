package com.jamal.springDemo.domain;

import com.jamal.springDemo.service.RecruitmentService;

public class HumanResourceDept implements Department {

	private String deptName;
	private RecruitmentService recruitmentService;
	private OrganisationDI organisation;
	
	public HumanResourceDept(RecruitmentService recruitmentService, OrganisationDI organisation) {
		this.recruitmentService = recruitmentService;
		this.organisation = organisation;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String hiringStatus(int numberOfRecruitments) {
		String hiringFacts = recruitmentService.recuitmentEmployees(organisation.getCompanyName(), deptName, numberOfRecruitments);
		return hiringFacts;
	}

}
