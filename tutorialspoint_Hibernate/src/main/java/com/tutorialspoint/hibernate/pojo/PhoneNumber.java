/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorialspoint.hibernate.pojo;

/**
 *
 * @author mkonda
 */
public class PhoneNumber {
    private int areaCode = 0;
    private String phoneNumber;
    private String name = null;
    
	public PhoneNumber() {	
	}
	
	public PhoneNumber(int areaCode, String phoneNumber, String name) {
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
