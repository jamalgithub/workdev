package com.tutorialspoint.eclipselink.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.tutorialspoint.eclipselink.entity.Family;

import javax.persistence.ManyToOne;

import com.tutorialspoint.eclipselink.entity.Job;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.OneToMany;

@Entity
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	private String firstName;
	private String lastName;
	@Transient
	private String nonsenseField;

	@ManyToOne
	private Family family;

	@OneToMany
	private Collection<Job> jobList;

	public Person() {
		jobList = new ArrayList<Job>();
	}

	public int getId() {
		return id;
	}

	public void setId(int param) {
		this.id = param;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String param) {
		this.firstName = param;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String param) {
		this.lastName = param;
	}

	public String getNonsenseField() {
		return nonsenseField;
	}

	public void setNonsenseField(String param) {
		this.nonsenseField = param;
	}

	public Family getFamily() {
	    return family;
	}

	public void setFamily(Family param) {
	    this.family = param;
	}

	public Collection<Job> getJobList() {
	    return jobList;
	}

	public void setJobList(Collection<Job> param) {
	    this.jobList = param;
	}
	
	@Override
	public String toString() {
	   	return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", family.Id=" + family.getId() + ", family.Description=" + family.getDescription() +"]";
	}

}