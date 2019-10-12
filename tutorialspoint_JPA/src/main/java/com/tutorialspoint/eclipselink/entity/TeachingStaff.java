package com.tutorialspoint.eclipselink.entity;

import javax.persistence.Entity;

@Entity
public class TeachingStaff extends Staff {
	
	private static final long serialVersionUID = 1L;
	private String qualification;
	private String subjectexpertise;

	public TeachingStaff(int sid, String sname, String qualification, String subjectexpertise) {
		super(sid, sname);
		this.qualification = qualification;
		this.subjectexpertise = subjectexpertise;
	}

	public TeachingStaff() {
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String param) {
		this.qualification = param;
	}

	public String getSubjectexpertise() {
		return subjectexpertise;
	}

	public void setSubjectexpertise(String param) {
		this.subjectexpertise = param;
	}

}