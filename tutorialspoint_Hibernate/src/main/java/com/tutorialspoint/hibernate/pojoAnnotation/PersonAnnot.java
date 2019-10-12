/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorialspoint.hibernate.pojoAnnotation;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON_ANNOT")
public class PersonAnnot {

	@Id
	@GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String nickName;
    @Embedded
    private PhoneNumberAnnot phoneNumber;
    
	public PersonAnnot() {
		
	}
	
	public PersonAnnot(String firstName, String lastName, String nickName, PhoneNumberAnnot phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public PhoneNumberAnnot getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(PhoneNumberAnnot phoneNumber) {
		this.phoneNumber = phoneNumber;
	}	
       
}
