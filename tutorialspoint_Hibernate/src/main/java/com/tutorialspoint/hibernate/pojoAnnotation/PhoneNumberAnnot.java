/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorialspoint.hibernate.pojoAnnotation;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PhoneNumberAnnot {
	
	@Column(name = "AREA_CODE")
    private int areaCode = 0;
	
	@Column(name = "PHONE_NUMBER", length=10)
    private String phoneNumber;
	
	@Column(name = "NAME")
    private String name = null;
    
	public PhoneNumberAnnot() {	
	}
	
	public PhoneNumberAnnot(int areaCode, String phoneNumber, String name) {
		this.areaCode = areaCode;
		this.phoneNumber = phoneNumber;
		this.name = name;
	}

	public int getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}        
}
