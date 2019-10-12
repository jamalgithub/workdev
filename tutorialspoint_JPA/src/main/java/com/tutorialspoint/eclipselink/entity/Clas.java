package com.tutorialspoint.eclipselink.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.tutorialspoint.eclipselink.entity.Teacher;
import java.util.Collection;
import javax.persistence.ManyToMany;

@Entity
public class Clas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	private String cname;

	@ManyToMany(mappedBy = "clas")
	private Collection<Teacher> teacher;
	
	public Clas() {
	}

	public Clas(int cid, String cname, Set<Teacher> teacher) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.teacher = teacher;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int param) {
		this.cid = param;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String param) {
		this.cname = param;
	}

	public void setTeacher(Set<Teacher> param) {
	    this.teacher = param;
	}

	public Collection<Teacher> getTeacher() {
	    return teacher;
	}

	public void setTeacher(Collection<Teacher> param) {
	    this.teacher = param;
	}

}