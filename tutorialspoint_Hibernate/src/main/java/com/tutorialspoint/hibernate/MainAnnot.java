package com.tutorialspoint.hibernate;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.tutorialspoint.hibernate.pojoAnnotation.AccountAnnot;
import com.tutorialspoint.hibernate.pojoAnnotation.AddressAnnot;
import com.tutorialspoint.hibernate.pojoAnnotation.CertificateAnnot;
import com.tutorialspoint.hibernate.pojoAnnotation.EmployeeAnnot;
import com.tutorialspoint.hibernate.pojoAnnotation.MeetingAnnot;
import com.tutorialspoint.hibernate.pojoAnnotation.PersonAnnot;
import com.tutorialspoint.hibernate.pojoAnnotation.PhoneNumberAnnot;

public class MainAnnot {
	private static SessionFactory factory = HibernateUtil.getSessionAnnotationFactory("hibernate-annotation.cfg.xml");;

	public static void main(String[] args) {		
		
		MainAnnot ma = new MainAnnot();
		
		/* Let us have one address object */
	    AddressAnnot address = ma.addAddress("Kondapur","Hyderabad","AP","532");
	    AddressAnnot address2 = new AddressAnnot("Kondapur0","Hyderabad0","AP0","531");
	    
	    /* Add few account records in database */
	    AccountAnnot account1 = ma.addAccount("description1");
	    AccountAnnot account2 = ma.addAccount("description2");
	    AccountAnnot account3 = ma.addAccount("description3");
		
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
		/*Integer empID1 = ma.addEmployee("Zara", "Ali", 1000, address, account1, set1, meetings);
		Integer empID2 = ma.addEmployee("Daisy", "Das", 5000, address, account2, set2, meetings);
		ma.addEmployee("John", "Paul", 10000, address2, account3, set3, meetings);*/
		
		EmployeeAnnot employee1 = null;
		EmployeeAnnot employee2 = null;
		EmployeeAnnot employee3;
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			address = (AddressAnnot) session.merge(address);
			account1 = (AccountAnnot) session.merge(account1);
			account2 = (AccountAnnot) session.merge(account2);
			account3 = (AccountAnnot) session.merge(account3);
			employee1 = new EmployeeAnnot("Zara", "Ali", 1000, address, account1, set1, meetings);
			employee2 = new EmployeeAnnot("Daisy", "Das", 5000, address, account2, set2, meetings);
			employee3 = new EmployeeAnnot("John", "Paul", 10000, address2, account3, set3, meetings);
			session.persist(employee1);
			session.persist(employee2);
			session.persist(employee3);
			
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) 
				tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		
		/* List down all the employees */
		ma.listEmployees();
		
		/* Update an employee */
		ma.updateEmployee(employee1, 4000);

		/* Delete an employee from the database */
		ma.deleteEmployee(employee2);
		
		/* Update an employee */
		ma.updateEmployee(employee1, 6000);

		/* List down new list of the employees */
		ma.listEmployees();
		
		PhoneNumberAnnot pn = new PhoneNumberAnnot(123, "0661050839", "PN1");
		PersonAnnot p = new PersonAnnot("said", "jika", "jipo", pn);
		
		ma.addPerson(p);
		
		MainAnnot.jointure2();
		
		factory.close();
	}
	
	/**
	  * Method to add a person record in the database 
	  */
	public void addPerson(PersonAnnot p) {
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			//session.save(p); //Hibernate
			session.persist(p); //JPA
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
	  * Method to add an account
	  * @return a detached AccountAnnot object
	  */
	public AccountAnnot addAccount(String description) {
		Session session = factory.openSession();
		Transaction tx = null;
		AccountAnnot account = null;
		try{
			tx = session.beginTransaction();
			account = new AccountAnnot(description);
			//session.save(account); //Hibernate
			session.persist(account); //JPA
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

	public EmployeeAnnot findEmployee(int id) {
		EmployeeAnnot emp = null;
		/*Session session = factory.openSession();		
		try{
			emp = (EmployeeAnnot) session.load(EmployeeAnnot.class, id);
		}catch (HibernateException e) {
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}*/
		Session session = factory.getCurrentSession();
		emp = (EmployeeAnnot) session.load(EmployeeAnnot.class, id);
		return emp;
	}
	
	/**
	  * Method to add an address
	  * @return a detached AddressAnnot object
	  */
	public AddressAnnot addAddress(String street, String city, String state, String zipcode) {
		Session session = factory.openSession();
		Transaction tx = null;
		AddressAnnot address = null;
		try{
			tx = session.beginTransaction();
			address = new AddressAnnot(street, city, state, zipcode);
			//session.save(address); //Hibernate
			session.persist(address); //JPA
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) 
				tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		//return addressID;
		return address;
	}
	
	/**
	 * Method to CREATE an employee
	 */	 
	public Integer addEmployee(String fname, String lname, int salary, AddressAnnot address, AccountAnnot account, Set<CertificateAnnot> set, Set<MeetingAnnot> meet){
		Session session = factory.openSession();
		Transaction tx = null;
		Integer employeeID = null;
		try{
			tx = session.beginTransaction();
			address = (AddressAnnot) session.merge(address);
			account = (AccountAnnot) session.merge(account);
			EmployeeAnnot employee = new EmployeeAnnot();
			employee.setFirstName(fname);
	        employee.setLastName(lname);
	        employee.setSalary(salary);
	        employee.setAddress(address);
	        employee.setAccount(account);
	        employee.setCertificates(set);	        
	        employee.setMeetings(meet);
			session.persist(employee); 
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
	 *  Method to  READ all the employees.
	 */
	public void listEmployees(){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			List<?> employees = session.createQuery("FROM EmployeeAnnot").list(); 
			for (Iterator<?> iterator = employees.iterator(); iterator.hasNext();){
				EmployeeAnnot employee = (EmployeeAnnot) iterator.next(); 
				System.out.println(employee); 
				AddressAnnot add = employee.getAddress();
				System.out.println(add);	        
	            AccountAnnot account = employee.getAccount();
	            System.out.println(account);
				Set<CertificateAnnot> certificates = employee.getCertificates();
				System.out.print("CertificateAnnots [ ");
				for (Iterator<CertificateAnnot> iterator2 = certificates.iterator(); iterator2.hasNext();){
					CertificateAnnot certName = iterator2.next(); 
					System.out.print(certName.getCertificateName());
					if(iterator2.hasNext())
						System.out.print(" ,");
				}
				System.out.println(" ]");
				Set<MeetingAnnot> meetings = employee.getMeetings();
	            System.out.print("MeetingAnnots [ ");
	            for (Iterator<MeetingAnnot> iterator3 = meetings.iterator(); iterator3.hasNext();){
	            	MeetingAnnot meetSubject = iterator3.next(); 
	            	System.out.print(meetSubject.getSubject());
	            	if(iterator3.hasNext())
	            		System.out.print(" ,");
	            }
	            System.out.println(" ]\n");	            
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
	 *  Method to UPDATE salary for a detached  employee
	 */
	public void updateEmployee(EmployeeAnnot emp, int salary ){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.saveOrUpdate(emp);
			//emp = (EmployeeAnnot) session.merge(emp);
			emp.setSalary( salary );
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
	 *  Method to DELETE a detached employee
	 */
	public void deleteEmployee(EmployeeAnnot emp){
		Session session = factory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			emp = (EmployeeAnnot) session.merge(emp);
			session.delete(emp); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) 
				tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
	}
	
	public static void jointure(){
		Session session = factory.openSession();
		
		try{
			Criteria cr = session.createCriteria(EmployeeAnnot.class,"e");
			cr.setFetchMode("e.certificates", FetchMode.JOIN);
			cr.createAlias("e.certificates","c");
			cr.add(Restrictions.eqProperty("e.certificates", "c.id"));
			List<EmployeeAnnot> res = cr.list();
			
			for (Iterator iterator = res.iterator(); iterator.hasNext();){
				System.out.print("[ ");
				EmployeeAnnot empa = (EmployeeAnnot) iterator.next();
				Set<CertificateAnnot> set = empa.getCertificates();
				System.out.print(empa.getFirstName()+"-"+empa.getLastName()+" [");
				for (Iterator iterator2 = set.iterator(); iterator2.hasNext();){
					CertificateAnnot ce = (CertificateAnnot) iterator2.next();
					System.out.print(ce.getCertificateName());
					if(iterator2.hasNext())
	            		System.out.print(", ");
				}
				System.out.println("]"); 
			}			
		}catch (HibernateException e) {			
			e.printStackTrace(); 
		}finally{
			session.close();
		}		
	}
	
	public static void jointure2(){
		Session session = factory.openSession();		
		try{
			Criteria cr = session.createCriteria(EmployeeAnnot.class,"e");
			cr.setFetchMode("e.address", FetchMode.JOIN);
			cr.createAlias("e.address","a");
			//cr.add(Restrictions.eqProperty("e.address", "a.id"));
			List<EmployeeAnnot> res = cr.list();
			
			for (Iterator iterator = res.iterator(); iterator.hasNext();){
				EmployeeAnnot empa = (EmployeeAnnot) iterator.next();
				AddressAnnot adr = empa.getAddress();
				System.out.println(empa.getFirstName()+"-"+empa.getLastName()+" "+adr);				
			}			
		}catch (HibernateException e) {			
			e.printStackTrace(); 
		}finally{
			session.close();
		}		
	}
}
