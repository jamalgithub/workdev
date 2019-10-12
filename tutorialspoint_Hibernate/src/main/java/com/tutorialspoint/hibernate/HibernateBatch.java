package com.tutorialspoint.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tutorialspoint.hibernate.pojoAnnotation.Emp;

public class HibernateBatch {
	private static SessionFactory sessionFactory;
	public static void main(String[] args) {
		sessionFactory = HibernateUtil.getSessionAnnotationFactory("hibernate-batch.cfg.xml");
		HibernateBatch HB = new HibernateBatch();
		HB.addEmployees();
		sessionFactory.close();
	}
	
	public void addEmployees(){
		Session session = sessionFactory.openSession(); 
		Transaction tx = null; 
		try{ 
			tx = session.beginTransaction(); 
			for ( int i=0; i<100000; i++ ) { 
			    Emp emp = new Emp("fn"+(i+1),"ln"+(i+1),10*(i+1)); 
			    //session.save(emp); // Hibernate
			    session.persist(emp); // JPA
			    /*if( i % 50 == 0 ) { 
				  	// Same as the JDBC batch size 
			        //flush a batch of inserts and release memory: 
			        session.flush(); 
			        session.clear(); 
			    } */
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
