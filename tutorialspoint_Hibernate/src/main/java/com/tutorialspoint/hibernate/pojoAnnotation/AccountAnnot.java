package com.tutorialspoint.hibernate.pojoAnnotation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="ACCOUNT_ANNOT")
public class AccountAnnot implements java.io.Serializable {
	
	@Id
	@GeneratedValue
	private int id;
	private String description;
	@Version
	private int version;
	
	public AccountAnnot() {		
	}

	public AccountAnnot(String description) {
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "AccountAnnot [description=" + description + ", version=" + version + "]";
	}
	
}
