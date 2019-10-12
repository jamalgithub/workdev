package com.tutorialspoint.hibernate.pojoAnnotation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

// Generated 21 d�c. 2014 20:05:48 by Hibernate Tools 4.0.0

@Entity
@Table(name = "CERTIFICATE_ANNOT")
public class CertificateAnnot implements java.io.Serializable {

	@Id
	@GeneratedValue
	private Integer id;
	private String certificateName;	
	@Version
	private int version;
	
	public CertificateAnnot() {
	}

	public CertificateAnnot(String certificateName) {
		this.certificateName = certificateName;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCertificateName() {
		return this.certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "CertificateAnnot [certificateName=" + certificateName + ", version=" + version + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((certificateName == null) ? 0 : certificateName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CertificateAnnot other = (CertificateAnnot) obj;
		if (certificateName == null) {
			if (other.certificateName != null)
				return false;
		} else if (!certificateName.equals(other.certificateName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	

}
