package com.jamal.springDemo.serviceImp;

import java.util.Random;

import com.jamal.springDemo.service.RecruitmentService;

public class AgenceRecruitmenServicetImpl implements RecruitmentService {

	@Override
	public String recuitmentEmployees(String companyName, String departmentName, int numberOfRecruitments) {
		Random random = new Random();
		String hiringFacts = "\n" + companyName + "'s " + departmentName + " hired" + 
				random.nextInt(numberOfRecruitments) + " employees " + 
				"using various agences.";
		return hiringFacts;
	}

}
