package com.tutorialspoint.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tutorialspoint.hibernate.pojoAnnotation.NonTeachingStaff;
import com.tutorialspoint.hibernate.pojoAnnotation.TeachingStaff;


public class HibernateInheritence {
	private static SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory("hibernate-inheritance.cfg.xml");
	
	public static void main(String[] args) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			//Teaching staff entity 
		   	TeachingStaff ts1=new TeachingStaff("Gopal", "MSc MEd", "Maths");
		   	ts1.setSid(1);
		   	TeachingStaff ts2=new TeachingStaff("Manisha", "BSc BEd", "English");
		   	ts2.setSid(2);
		   	
		    //Non-Teaching Staff entity
		   	NonTeachingStaff nts1=new NonTeachingStaff("Satish", "Accounts");
		   	nts1.setSid(3);
		   	NonTeachingStaff nts2=new NonTeachingStaff("Krishna", "Office Admin");
		   	nts2.setSid(4);
		   	
			session.persist(ts1);
			session.persist(ts2);
			session.persist(nts1);
			session.persist(nts2);

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
