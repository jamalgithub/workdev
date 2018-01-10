package com.in28minutes.database.databasedemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

//Table - User
@Entity
@NamedQuery(query = "select u from User u", name = "query_find_all_users")
public class User {

	@Id
	@GeneratedValue
	private long id;

	private String name;

	private String role;

	protected User() {

	}

	public User(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, role=%s]", id, name, role);
	}
}