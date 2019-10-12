package com.tutorialspoint.hibernate.pojoAnnotation;

import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "EMPLOYEE_ANNOT")
public class EmployeeAnnot implements java.io.Serializable{
	   
	   @Id 
	   @GeneratedValue
	   @Column(name = "id")
	   private int id;
	
	   @Column(name = "first_name")
	   private String firstName;
	
	   @Column(name = "last_name")
	   private String lastName;
	
	   @Column(name = "salary")
	   private int salary;  
	   
	   @Version
	   private int version;
	   
	   @ManyToOne(targetEntity=AddressAnnot.class, cascade=CascadeType.PERSIST)
	   @JoinColumn(name="address_id", nullable=false)
	   private AddressAnnot address;
	   
	   //@ManyToOne(targetEntity=AccountAnnot.class, cascade=CascadeType.REMOVE)
	   //@JoinColumn(name="ACCOUNT_ID", unique=true)
	   @OneToOne(targetEntity=AccountAnnot.class, cascade={CascadeType.REMOVE, CascadeType.PERSIST})
	   @JoinColumn(name="account_id", nullable=false, unique=true)
	   private AccountAnnot account;
	   
	   @OneToMany(targetEntity=CertificateAnnot.class, cascade = CascadeType.ALL)
	   @JoinColumn(name="employee_id")
	   private Set<CertificateAnnot> certificates;
	   
	   @ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	   @JoinTable(
			   name="EMPLOYEE_MEETING_ANNOT",
			   joinColumns={@JoinColumn(name="employee_id")},
			   inverseJoinColumns={@JoinColumn(name="meeting_id")}
       )
	   private Set<MeetingAnnot> meetings;
	   
	   public EmployeeAnnot(String firstName, String lastName, int salary, AddressAnnot address, AccountAnnot account,
			Set<CertificateAnnot> certificates, Set<MeetingAnnot> meetings) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.salary = salary;
			this.address = address;
			this.account = account;
			this.certificates = certificates;
			this.meetings = meetings;
		}
		public EmployeeAnnot() {
		   
	   }
	   public int getId() {
	      return id;
	   }
	   public void setId( int id ) {
	      this.id = id;
	   }
	   public String getFirstName() {
	      return firstName;
	   }
	   public void setFirstName( String first_name ) {
	      this.firstName = first_name;
	   }
	   public String getLastName() {
	      return lastName;
	   }
	   public void setLastName( String last_name ) {
	      this.lastName = last_name;
	   }
	   public int getSalary() {
	      return salary;
	   }
	   public void setSalary( int salary ) {
	      this.salary = salary;
	   }
	   public Set<CertificateAnnot> getCertificates() {
		   return certificates;
	   }
	   public void setCertificates(Set<CertificateAnnot> certificates) {
		   this.certificates = certificates;
	   }
	   public AddressAnnot getAddress() {
		   return address;
	   }
	   public void setAddress(AddressAnnot address) {
		   this.address = address;
	   }
	   public AccountAnnot getAccount() {
		   return account;
	   }
	   public void setAccount(AccountAnnot account) {
		   this.account = account;
	   }
	   public Set<MeetingAnnot> getMeetings() {
		   return meetings;
	   }
	   public void setMeetings(Set<MeetingAnnot> meetings) {
		   this.meetings = meetings;
	   }
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "EmployeeAnnot [firstName=" + firstName + ", lastName="
				+ lastName + ", salary=" + salary + ", version=" + version	+ "]";
	}
	   
}