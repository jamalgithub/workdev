package com.tutorialspoint.hibernate.pojoAnnotation;

import javax.persistence.Entity;

@Entity
public class NonTeachingStaff extends Staff {
	
	private static final long serialVersionUID = 1L;
	private String areaexpertise;

	public NonTeachingStaff(String sname, String areaexpertise) {
		super(sname);
		this.areaexpertise = areaexpertise;
	}

	public NonTeachingStaff() {
	}

	public String getAreaexpertise() {
		return areaexpertise;
	}

	public void setAreaexpertise(String param) {
		this.areaexpertise = param;
	}

}