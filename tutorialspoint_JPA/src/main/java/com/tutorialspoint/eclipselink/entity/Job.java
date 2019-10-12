package com.tutorialspoint.eclipselink.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Job implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	private double salery;
	private String jobDescr;

	public Job() {
	}

	public int getId() {
		return id;
	}

	public void setId(int param) {
		this.id = param;
	}

	public double getSalery() {
		return salery;
	}

	public void setSalery(double param) {
		this.salery = param;
	}

	public String getJobDescr() {
		return jobDescr;
	}

	public void setJobDescr(String param) {
		this.jobDescr = param;
	}
	
	@Override
	public String toString() {
	   	return "Job [id=" + id + ", salery=" + salery + ", jobDescr=" + jobDescr +"]";
	}

}