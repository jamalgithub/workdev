package com.tutorialspoint.hibernate.pojoAnnotation;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Staff implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private int sid;
	private String sname;

	public Staff(String sname) {
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