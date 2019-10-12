package com.tutorialspoint.hibernate.pojoAnnotation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="ADDRESS_ANNOT")
public class AddressAnnot implements java.io.Serializable {

	@Id
	@GeneratedValue
	private Integer id;
	private String streetName;
	private String cityName;
	private String stateName;
	private String zipCode;
	@Version
	private int version;

	public AddressAnnot() {
	}

	public AddressAnnot(String streetName, String cityName, String stateName, String zipCode) {
		this.streetName = streetName;
		this.cityName = cityName;
		this.stateName = stateName;
		this.zipCode = zipCode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "AddressAnnot [streetName=" + streetName + ", cityName="
				+ cityName + ", stateName=" + stateName + ", zipCode="
				+ zipCode + ", version=" + version + "]";
	}

}
