package com.tutorialspoint.eclipselink.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@NamedQuery(name = "Emp.findById", query = "Select e from Emp e where e.eid = :id")
@NamedQueries({
    @NamedQuery(name="Emp.findAll", query="SELECT e FROM Emp e"),
    @NamedQuery(name="Emp.findByName", query="SELECT e FROM Emp e WHERE e.ename = :name")
})
public class Emp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int eid;

	private String deg;

	private String ename;

	private double salary;

	public Emp() {
	}

	public int getEid() {
		return this.eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getDeg() {
		return this.deg;
	}

	public void setDeg(String deg) {
		this.deg = deg;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getSalary() {
		return this.salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
	   	return "Employee [eid=" + eid + ", ename=" + ename + ", salary=" + salary + ", deg=" + deg + "]";
	}
}