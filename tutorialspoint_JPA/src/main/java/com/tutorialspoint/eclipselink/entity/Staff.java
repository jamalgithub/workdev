package com.tutorialspoint.eclipselink.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Staff implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sid;
	private String sname;

	public Staff(int sid, String sname) {
		super();
		this.sid = sid;
		this.sname = sname;
	}

	public Staff() {
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int param) {
		this.sid = param;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String param) {
		this.sname = param;
	}

}