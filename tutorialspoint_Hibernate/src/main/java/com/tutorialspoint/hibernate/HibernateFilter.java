package com.tutorialspoint.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Filter;

import com.tutorialspoint.hibernate.pojoAnnotation.Car;

public class HibernateFilter {
	private static SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory("hibernate-filter.cfg.xml");
	
	public static void main(String[] args) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			Car car = null;
	        for (int i = 0; i < 5; i++) {
	            car = new Car();
	            car.setName("BMW Green Car");
	            car.setModel("X" + i);
	            car.setMake("BMW");
	            car.setColor("color"+i+"b");
	            session.persist(car);
	        }
	        for (int i = 0; i < 5; i++) {
	            car = new Car();
	            car.setName("Mercedes white Car");
	            car.setModel("Y" + i);
	            car.setMake("Mercedes");
	            car.setColor("color"+i+"m");
	            session.persist(car);
	        }
	        
	        Filter filter = session.enableFilter("filterByBMWMake");//  select * from CARS where make= ?
	        filter.setParameter("make", "BMW");

	        List<?> results = session.createQuery("from Car").list();	       
	        for (Iterator<?> iterator =  results.iterator(); iterator.hasNext();){ 
				Car c = (Car) iterator.next();  				
				System.out.println(c);  
			} 

			transaction.commit();
		} catch (HibernateException e) {
			if(transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
