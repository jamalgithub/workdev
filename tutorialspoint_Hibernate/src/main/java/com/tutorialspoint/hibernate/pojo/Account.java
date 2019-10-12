package com.tutorialspoint.hibernate.pojo;

public class Account implements java.io.Serializable {
	
	private int id;
	private String description;
	
	public Account() {		
	}

	public Account(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
