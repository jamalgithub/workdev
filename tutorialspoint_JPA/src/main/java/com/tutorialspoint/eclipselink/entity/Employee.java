package com.tutorialspoint.eclipselink.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int eid;
	private String ename;
	private double salary;
	private String deg;
	
	public Employee() {
	}
	
	public Employee(int eid, String ename, double salary, String deg) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.salary = salary;
		this.deg = deg;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String param) {
		this.ename = param;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double param) {
		this.salary = param;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int param) {
		this.eid = param;
	}

	public String getDeg() {
		return deg;
	}

	public void setDeg(String param) {
		this.deg = param;
	}

}