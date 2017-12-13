package com.jamal.springdemo.domain.test;

import java.io.Serializable;

public class Visitor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1331334233162349991L;
	
	private String name;
	private String email;
	
	public Visitor(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Visitor [name=" + name + ", email=" + email + "]";
	}
}
