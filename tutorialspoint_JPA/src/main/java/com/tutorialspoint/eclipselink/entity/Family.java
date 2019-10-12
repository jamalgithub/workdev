package com.tutorialspoint.eclipselink.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.tutorialspoint.eclipselink.entity.Person;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.OneToMany;

@Entity
public class Family implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Id
	private int id;
	private String description;

	@OneToMany(mappedBy = "family")
	private Collection<Person> members;

	public Family() {
		members = new ArrayList<Person>();
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String param) {
		this.description = param;
	}

	public int getId() {
		return id;
	}

	public void setId(int param) {
		this.id = param;
	}

	public Collection<Person> getMembers() {
	    return members;
	}

	public void setMembers(Collection<Person> param) {
	    this.members = param;
	}

}