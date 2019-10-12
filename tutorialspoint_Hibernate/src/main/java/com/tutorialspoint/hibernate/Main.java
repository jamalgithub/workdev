package com.tutorialspoint.hibernate;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.tutorialspoint.hibernate.pojo.Account;
import com.tutorialspoint.hibernate.pojo.Address;
import com.tutorialspoint.hibernate.pojo.Certificate;
import com.tutorialspoint.hibernate.pojo.Employee;
import com.tutorialspoint.hibernate.pojo.Meeting;
import com.tutorialspoint.hibernate.pojo.Person;
import com.tutorialspoint.hibernate.pojo.PhoneNumber;

public class Main {
	private static SessionFactory factory;
	
	public static void main(String[] args) {
		try{
	         //factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	         Configuration config = new Configuration().configure("hibernate.cfg.xml");
	         //ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
	         //factory = config.buildSessionFactory(serviceRegistry);
	         factory = config.buildSessionFactory();
	    }
		catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	    }
		
		Main m = new Main();
		
		/* Let us have one address object */
	    Address address = m.addAddress("Kondapur","Hyderabad","AP","532");
	    
	    /* Add few account records in database */
	    Account account1 = m.addAccount("description1");
	    Account account2 = m.addAccount("description2");
	    Account account3 = m.addAccount("description3");
	    
	    /* Let us have a set of certificates for the first employee  */
	    HashSet<Certificate> set1 = new HashSet<Certificate>();
	    set1.add(new Certificate("MCA"));
	    set1.add(new Certificate("MBA"));
	    set1.add(new Certificate("PMP"));
	    
	    /* Another set of certificates for the second employee  */
	    HashSet<Certificate> set2 = new HashSet<Certificate>();
	    set2.add(new Certificate("BCA"));
	    set2.add(new Certificate("BA"));
	    
	    /* Another set of certificates for the second employee  */
	    HashSet<Certificate> set3 = new HashSet<Certificate>();
	    set3.add(new Certificate("DMCA"));
	    set3.add(new Certificate("DMA"));
	    
	    /* Let us have a set of meetings for the first employee  */
	    HashSet<Meeting> meetings = new HashSet<Meeting>();
	    meetings.add(new Meeting("Meeting 1"));
	    meetings.add(new Meeting("Meeting 2"));
	    meetings.add(new Meeting("Meeting 3"));
	    
		/* Add few employee records in database */
		Integer empID1 = m.addEmployee("Zara", "Ali", 1000, address, account1, set1, meetings);
		Integer empID2 = m.addEmployee("Daisy", "Das", 5000, address, account2, set2, meetings);
		m.addEmployee("John", "Paul", 10000, address, account3, set3, meetings);

		/* List down all the employees */
		m.listEmployees();

		/* Update employee's records */
		m.updateEmployee(empID1, 5000);

		/* Delete an employee from the database */
		m.deleteEmployee(empID2);

		/* List down new list of the employees */
		m.listEmployees();
		
		PhoneNumber pn = new PhoneNumber(123, "0661050839", "PN1");
		Person p = new Person("said", "jika", "jipo", pn);
		m.addPerson(p);
		
		factory.close();
	}
	
	/**
	  * Method to add a person record in the database 
	  */
	public void addPerson(Person p) {
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(p); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) 
				tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
	}
	
	/**
	  * Method to add an account record in the database 
	  */
	public Account addAccount(String description) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer accountID = null;
		Account account = null;
		try{
			tx = session.beginTransaction();
			account = new Account(description);
			accountID = (Integer) session.save(account); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) 
				tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return account;
	}
	
	 /**
	  * Method to add an address record in the database 
	  */
	public Address addAddress(String street, String city, String state, String zipcode) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer addressID = null;
		Address address = null;
		try{
			tx = session.beginTransaction();
			address = new Address(street, city, state, zipcode);
			addressID = (Integer) session.save(address); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) 
				tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return address;
	}
	
	/**
	 * Method to CREATE an employee in the database
	 */	 
	public Integer addEmployee(String fname, String lname, int salary, Address address, Account account, Set<Certificate> cert, Set<Meeting> meet){
		Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeID = null;
		try{
			tx = session.beginTransaction();
			Employee employee = new Employee(fname, lname, salary, address, account, cert, meet);
			employeeID = (Integer) session.save(employee); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) 
				tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return employeeID;
	}
	
	/**
	 *  Method to  READ all the employees 
	 */
	public void listEmployees( ){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			List<?> employees = session.createQuery("FROM Employee").list(); 
			for (Iterator<?> iterator = employees.iterator(); iterator.hasNext();){
				Employee employee = (Employee) iterator.next(); 
				System.out.print("First Name: " + employee.getFirstname()); 
				System.out.print("  Last Name: " + employee.getLastname()); 
				System.out.println("  Salary: " + employee.getSalary());
				Address add = employee.getAddress();
				System.out.print("Address [ ");
	            System.out.print("Street: " +  add.getStreetName());
	            System.out.print(", City: " + add.getCityName());
	            System.out.print(", State: " + add.getStateName());
	            System.out.print(", Zipcode: " + add.getZipCode());
	            System.out.println(" ]");
	            Account account = employee.getAccount();
	            System.out.print("Account [ ");
	            System.out.println("Description: " +  account.getDescription() + " ]");
	            Set<Certificate> certificates = employee.getCertificates();
	            System.out.print("Certificate [ ");
	            for (Iterator<Certificate> iterator2 = certificates.iterator(); iterator2.hasNext();){
	            	Certificate certName = (Certificate) iterator2.next(); 
	            	System.out.print(certName.getCertificateName());
	            	if(iterator2.hasNext())
	            		System.out.print(" ,");
	            }
	            System.out.println(" ]");
	            Set<Meeting> meetings = employee.getMeetings();
	            System.out.print("Meeting [ ");
	            for (Iterator<Meeting> iterator3 = meetings.iterator(); iterator3.hasNext();){
	            	Meeting meetSubject = (Meeting) iterator3.next(); 
	            	System.out.print(meetSubject.getSubject());
	            	if(iterator3.hasNext())
	            		System.out.print(" ,");
	            }
	            System.out.println(" ]");
			}
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) 
				tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
	}
	
	/**
	 *  Method to UPDATE salary for an employee
	 */
	public void updateEmployee(Integer EmployeeID, int salary ){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
			employee.setSalary( salary );
			session.update(employee); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) 
				tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
	}
	
	/**
	 *  Method to DELETE an employee from the records 
	 */
	public void deleteEmployee(Integer EmployeeID){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
			session.delete(employee); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) 
				tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
	}

}
