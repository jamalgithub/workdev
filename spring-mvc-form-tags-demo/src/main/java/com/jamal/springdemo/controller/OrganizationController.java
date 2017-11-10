package com.jamal.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jamal.springdemo.domain.Organization;
import com.jamal.springdemo.service.OrganizationService;

@Controller
public class OrganizationController {
	
	@Autowired
	private OrganizationService organizationService;
	
	@RequestMapping("/location")
	public String addLocation() {
		return "location";
	}
	
	@RequestMapping("/listOrgs")
	public String listOrganizations(Model model) {
		List<Organization> orgs = organizationService.getOrgList();
		model.addAttribute("orgList", orgs);
		return "listOrganizations";
	}

}
