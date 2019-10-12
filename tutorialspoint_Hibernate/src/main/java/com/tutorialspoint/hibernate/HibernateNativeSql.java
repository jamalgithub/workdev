package com.tutorialspoint.hibernate;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tutorialspoint.hibernate.pojoAnnotation.Emp;

public class HibernateNativeSql {
	private static SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory("hibernate-nativeSql.cfg.xml");	
	
	public static void main(String[] args) {
		HibernateNativeSql HNQ = new HibernateNativeSql();
		HNQ.listEmployeesScalar();
		HNQ.listEmployeesEntity(3700);
		
		sessionFactory.close();
	}
	
	/**
	 *  Method to  READ all the employees using Scalar Query 
	 */ 
	public void listEmployeesScalar(){ 
		Session session = sessionFactory.openSession(); 
		Transaction tx = null; 
		try{ 
			tx = session.beginTransaction(); 
			String sql = "SELECT first_name, salary FROM EMP"; 
			SQLQuery query = session.createSQLQuery(sql); 
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP); 
			List<?> data = query.list(); 
 
			for(Object object : data) 
			{ 
				Map<?, ?> row = (Map<?, ?>)object; 
				System.out.print("First Name: " + row.get("first_name"));  
				System.out.println(", Salary: " + row.get("salary"));  
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
	 *  Method to  READ all the employees using Entity Query 
	 */ 
	public void listEmployeesEntity(int salary){ 
		Session session = sessionFactory.openSession(); 
		Transaction tx = null; 
		try{ 
			tx = session.beginTransaction(); 
			String sql = "SELECT * FROM EMP  WHERE salary > :salary"; 
			SQLQuery query = session.createSQLQuery(sql); 
			query.addEntity(Emp.class);
			query.setParameter("salary", salary);
			List<?> employees = query.list(); 
 
			for (Iterator<?> iterator =  employees.iterator(); iterator.hasNext();){ 
				Emp employee = (Emp) iterator.next();				
				System.out.println(employee);  
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

}
