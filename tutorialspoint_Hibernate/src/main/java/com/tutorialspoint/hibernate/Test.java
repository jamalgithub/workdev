package com.tutorialspoint.hibernate;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tutorialspoint.hibernate.pojoAnnotation.AccountAnnot;
import com.tutorialspoint.hibernate.pojoAnnotation.AddressAnnot;
import com.tutorialspoint.hibernate.pojoAnnotation.CertificateAnnot;
import com.tutorialspoint.hibernate.pojoAnnotation.EmployeeAnnot;
import com.tutorialspoint.hibernate.pojoAnnotation.MeetingAnnot;

public class Test {

	public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory("hibernate-annotation.cfg.xml");
        Session session = null;
        Transaction tx = null;
        Integer employeeID = null;
        
        AddressAnnot address = new AddressAnnot("Kondapur","Hyderabad","AP","532");
        /* Add few account records in database */
	    AccountAnnot account1 = new AccountAnnot("description1");
	    AccountAnnot account2 = new AccountAnnot("description2");
	    AccountAnnot account3 = new AccountAnnot("description3");
		
		/* Let us have a set of certificates for the first employee  */
	    HashSet<CertificateAnnot> set1 = new HashSet<CertificateAnnot>();
	    set1.add(new CertificateAnnot("MCA"));
	    set1.add(new CertificateAnnot("MBA"));
	    set1.add(new CertificateAnnot("PMP"));
	    
	    /* Another set of certificates for the second employee  */
	    HashSet<CertificateAnnot> set2 = new HashSet<CertificateAnnot>();
	    set2.add(new CertificateAnnot("BCA"));
	    set2.add(new CertificateAnnot("BA"));
	    
	    /* Another set of certificates for the second employee  */
	    HashSet<CertificateAnnot> set3 = new HashSet<CertificateAnnot>();
	    set3.add(new CertificateAnnot("DMCA"));
	    set3.add(new CertificateAnnot("DMA"));
	    
	    /* Let us have a set of meetings for the first employee  */
	    HashSet<MeetingAnnot> meetings = new HashSet<MeetingAnnot>();
	    meetings.add(new MeetingAnnot("Meeting 1"));
	    meetings.add(new MeetingAnnot("Meeting 2"));
	    meetings.add(new MeetingAnnot("Meeting 3"));
		
		/* Add few employee records in database */
	    EmployeeAnnot empID1 = new EmployeeAnnot("Zara", "Ali", 1000, address, account1, set1, meetings);
	    EmployeeAnnot empID2 = new EmployeeAnnot("Daisy", "Das", 5000, address, account2, set2, meetings);
	    EmployeeAnnot empID3 = new EmployeeAnnot("John", "Paul", 10000, address, account3, set3, meetings);
				
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(account1);session.save(account2);session.save(account3);
			session.persist(empID1);
			session.persist(empID2);
			session.persist(empID3);
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) 
				tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}                
            
		listEmployees(sessionFactory);
		deleteEmployee(sessionFactory, empID2);
		listEmployees(sessionFactory);
		
        sessionFactory.close();
	}
	
	public static void listEmployees(SessionFactory sessionFactory){
		Session session = null;
		Transaction tx = null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			List<?> employees = session.createQuery("FROM EmployeeAnnot").list(); 
			for (Iterator<?> iterator = employees.iterator(); iterator.hasNext();){
				EmployeeAnnot employee = (EmployeeAnnot) iterator.next(); 
				System.out.print("First Name: " + employee.getFirstName()); 
				System.out.print("  Last Name: " + employee.getLastName()); 
				System.out.println("  Salary: " + employee.getSalary());
				AddressAnnot add = employee.getAddress();
				System.out.print("AddressAnnot [ ");
	            System.out.print("Street: " +  add.getStreetName());
	            System.out.print(", City: " + add.getCityName());
	            System.out.print(", State: " + add.getStateName());
	            System.out.print(", Zipcode: " + add.getZipCode());
	            System.out.println(" ]");
	            AccountAnnot account = employee.getAccount();
	            System.out.print("AccountAnnot [ ");
	            System.out.println("Description: " +  account.getDescription() + " ]");
				Set<CertificateAnnot> certificates = employee.getCertificates();
				System.out.print("CertificateAnnot [ ");
				for (Iterator<CertificateAnnot> iterator2 = certificates.iterator(); iterator2.hasNext();){
					CertificateAnnot certName = iterator2.next(); 
					System.out.print(certName.getCertificateName());
					if(iterator2.hasNext())
						System.out.print(" ,");
				}
				System.out.println(" ]");
				Set<MeetingAnnot> meetings = employee.getMeetings();
	            System.out.print("MeetingAnnot [ ");
	            for (Iterator<MeetingAnnot> iterator3 = meetings.iterator(); iterator3.hasNext();){
	            	MeetingAnnot meetSubject = iterator3.next(); 
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

	public static void deleteEmployee(SessionFactory sessionFactory,EmployeeAnnot EmployeeID){
		Session session = null;
		Transaction tx = null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.delete(EmployeeID); 
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
