package com.tutorialspoint.eclipselink.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.tutorialspoint.eclipselink.entity.Clas;
import java.util.Collection;
import javax.persistence.ManyToMany;

@Entity
public class Teacher implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int tid;
	private String tname;
	private String subject;

	@ManyToMany
	private Collection<Clas> clas;
	
	public Teacher() {
	}

	public Teacher(int tid, String tname, String subject, Set<Clas> clas) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.subject = subject;
		this.clas = clas;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int param) {
		this.tid = param;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String param) {
		this.tname = param;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String param) {
		this.subject = param;
	}

	public void setClas(Set<Clas> param) {
	    this.clas = param;
	}

	public Collection<Clas> getClas() {
	    return clas;
	}

	public void setClas(Collection<Clas> param) {
	    this.clas = param;
	}

}