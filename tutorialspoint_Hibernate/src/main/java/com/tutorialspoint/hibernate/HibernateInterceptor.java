package com.tutorialspoint.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tutorialspoint.hibernate.pojoAnnotation.Emp;

public class HibernateInterceptor {
	private static SessionFactory sessionFactory;
	
	public static void main(String[] args) {
		
		sessionFactory = HibernateUtil.getSessionAnnotationFactory("hibernate-interceptor.cfg.xml");
		HibernateInterceptor HI = new HibernateInterceptor();
		/* Add few employee records in database */ 
		Integer empID1 = HI.addEmployee("Zara", "Ali", 1000); 
		Integer empID2 = HI.addEmployee("Daisy", "Das", 5000); 
		Integer empID3 = HI.addEmployee("John", "Paul", 10000); 
 
		/* List down all the employees */ 
		HI.listEmployees(); 
 
		/* Update employee's records */ 
		HI.updateEmployee(empID1, 5000); 
 
		/* Delete an employee from the database */ 
		HI.deleteEmployee(empID2); 
 
		/* List down new list of the employees */ 
		HI.listEmployees();
		
		sessionFactory.close();
	}
	
	/**
	 *  Method to CREATE an employee
	 */ 
	public Integer addEmployee(String fname, String lname, int salary){ 
		Session session = sessionFactory.withOptions().interceptor(new MyInterceptor()).openSession(); 
		Transaction tx = null; 
		Integer employeeID = null; 
		try{ 
			tx = session.beginTransaction(); 
			Emp employee = new Emp(fname, lname, salary); 
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
		Session session = sessionFactory.withOptions().interceptor(new MyInterceptor()).openSession();
		try{ 
			List<?> employees = session.createQuery("FROM Emp").list();  
			for (Iterator<?> iterator =  employees.iterator(); iterator.hasNext();){ 
				Emp employee = (Emp) iterator.next();  				
				System.out.println(employee);  
			} 
		}catch (HibernateException e) { 
			e.printStackTrace();  
		}finally { 
			session.close();  
		} 
	}
	
	/**
	 *  Method to UPDATE salary for an employee 
	 */ 
	public void updateEmployee(Integer EmployeeID, int salary ){ 
		Session session = sessionFactory.withOptions().interceptor(new MyInterceptor()).openSession(); 
		Transaction tx = null; 
		try{ 
			tx = session.beginTransaction(); 
			Emp employee =  (Emp)session.get(Emp.class, EmployeeID);  
			employee.setSalary( salary );
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
		Session session = sessionFactory.withOptions().interceptor(new MyInterceptor()).openSession();
		Transaction tx = null; 
		try{ 
			tx = session.beginTransaction(); 
			Emp employee =  (Emp)session.get(Emp.class, EmployeeID);  
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
