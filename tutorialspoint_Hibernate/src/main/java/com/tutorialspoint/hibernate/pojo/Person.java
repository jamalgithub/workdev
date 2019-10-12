/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorialspoint.hibernate.pojo;

/**
 *
 * @author mkonda
 */
public class Person {

    private int id;
    private String firstName;
    private String lastName;
    private String nickName;
    private PhoneNumber phoneNumber;
    
	public Person() {
		
	}
	
	public Person(String firstName, String lastName, String nickName, PhoneNumber phoneNumber) {
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
	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}	
       
}
