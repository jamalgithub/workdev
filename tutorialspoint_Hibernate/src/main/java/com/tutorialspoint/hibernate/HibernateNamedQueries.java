package com.tutorialspoint.hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.tutorialspoint.hibernate.pojoAnnotation.Emp;


public class HibernateNamedQueries {
	private static SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory("hibernate-namedQueries.cfg.xml");
	
	public static void main(String[] args) {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.getNamedQuery("GET_EMP"); 
			List<?> results = query.list();
			for (Iterator<?> iterator = results.iterator(); iterator.hasNext();){
				Emp l = (Emp) iterator.next();
				System.out.println(l); 
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

}
