package com.tutorialspoint.eclipselink.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.tutorialspoint.eclipselink.entity.Employee;
import java.util.Collection;
import javax.persistence.OneToMany;

@Entity
public class Department implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;

	@OneToMany(targetEntity=Employee.class)
	private Collection<Employee> employee;

	public Department() {
	}

	public int getId() {
		return id;
	}

	public void setId(int param) {
		this.id = param;
	}

	public String getName() {
		return name;
	}

	public void setName(String param) {
		this.name = param;
	}

	public Collection<Employee> getEmployee() {
	    return employee;
	}

	public void setEmployee(Collection<Employee> param) {
	    this.employee = param;
	}

}