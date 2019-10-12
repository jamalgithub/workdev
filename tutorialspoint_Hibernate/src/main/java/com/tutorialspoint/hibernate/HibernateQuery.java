package com.tutorialspoint.hibernate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tutorialspoint.hibernate.pojoAnnotation.Emp;

public class HibernateQuery {	
	private static SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory("hibernate-query.cfg.xml");
	
	public static void main(String[] args) {				
		from_Query();
		as_Query();
		select_Query();
		where_Query();
		orderBy_Query();
		groupBy_Query();
		namedParamters_Query();
		update_Query(1,15000);
		delete_Query(4);
		//insertInto_Query("INSERT INTO Emp(firstName, lastName, salary) SELECT firstName, lastName, salary FROM old_emp");
		aggregate_Query();
		pagination_Query(1,3);
		
        sessionFactory.close();
	}
	
	public static void from_Query() {
		Session session = sessionFactory.openSession();
		String hql = "FROM Emp";   //<==> "SELECT E.firstName FROM Emp E"
		try {
			Query query = session.createQuery(hql); 
			List<?> results = query.list();
			for (Iterator<?> iterator = results.iterator(); iterator.hasNext();){
				Emp l = (Emp) iterator.next();
				System.out.println(l); 
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static void as_Query() {
		Session session = sessionFactory.openSession();
		String hql = "FROM Emp AS E";   //<==> "FROM Emp E"
		try {
			Query query = session.createQuery(hql); 
			List<?> results = query.list();
			for (Iterator<?> iterator = results.iterator(); iterator.hasNext();){
				Emp l = (Emp) iterator.next();
				System.out.println(l);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static void select_Query() {
		Session session = sessionFactory.openSession();
		String hql = "SELECT E.firstName FROM Emp E";
		try {
			Query query = session.createQuery(hql); 
			List<?> results = query.list();
			for (Iterator<?> iterator = results.iterator(); iterator.hasNext();){
				String l = (String) iterator.next();
				System.out.println("First Name: " + l); 			
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
		
	public static void where_Query() {
		Session session = sessionFactory.openSession();
		String hql = "FROM Emp E WHERE E.salary > 2000";
		try {
			Query query = session.createQuery(hql); 
			List<?> results = query.list();
			for (Iterator<?> iterator = results.iterator(); iterator.hasNext();){
				Emp l = (Emp) iterator.next();
				System.out.println(l); 
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static void orderBy_Query() {
		Session session = sessionFactory.openSession();
		String hql = "FROM Emp E WHERE E.salary > 2000 ORDER BY E.firstName DESC";
		try {
			Query query = session.createQuery(hql);
			List<?> results = query.list();
			for (Iterator<?> iterator = results.iterator(); iterator.hasNext();) {
				Emp l = (Emp) iterator.next();
				System.out.println(l);
			}
		} catch (HibernateException e) {			
			e.printStackTrace();
		} finally {
			session.close();
		}		
	}
	
	public static void groupBy_Query() {
		Session session = sessionFactory.openSession();
		String hql = "SELECT SUM(E.salary), E.firstName FROM Emp E GROUP BY E.firstName";
		try {
			Query query = session.createQuery(hql); 
			List<?> results = query.list();
			for (Iterator<?> iterator = results.iterator(); iterator.hasNext();){
				Object[] o = (Object[]) iterator.next();
				System.out.print("[ Salary: " + o[0]); 
				System.out.println(",  First Name: " + o[1] +" ]"); 
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static void namedParamters_Query() {
		Session session = sessionFactory.openSession();
		String hql = "FROM Emp E WHERE E.salary > :salary";
		try {
			Query query = session.createQuery(hql);
			query.setParameter("salary", 3000);
			List<?> results = query.list();
			for (Iterator<?> iterator = results.iterator(); iterator.hasNext();){
				Emp l = (Emp) iterator.next();
				System.out.println(l);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void update_Query(int id,int salary) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "UPDATE Emp set salary = :salary WHERE id = :id";
			Query query = session.createQuery(hql);
			query.setParameter("salary", salary);
			query.setParameter("id", id);
			int result = query.executeUpdate();
			tx.commit();
			System.out.println("Rows updated: " + result);
		} catch (HibernateException e) {
			if (tx!=null) 
				tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}		
	}
	
	public static void delete_Query(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "DELETE FROM Emp WHERE id = :id";
			Query query = session.createQuery(hql);
			query.setParameter("id", id);			
			int result = query.executeUpdate();
			tx.commit();
			System.out.println("Rows deleted: " + result);
		} catch (HibernateException e) {
			if (tx!=null) 
				tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}		
	}
	
	public static void insertInto_Query(String hql) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery(hql);
			int result = query.executeUpdate();
			tx.commit();
			System.out.println("Rows inserted: " + result);
		} catch (HibernateException e) {
			if (tx!=null) 
				tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}		
	}
	
	public static void aggregate_Query() {
		Session session = sessionFactory.openSession();
		String hql =  "SELECT count(distinct E.firstName) FROM Emp E";  //avg, max, min, sum
		try {
			Query query = session.createQuery(hql); 
			List<?> results = query.list();
			System.out.println("count(distinct E.firstName): " + results.get(0));
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static void pagination_Query(int firstResult, int maxResults) {
		Session session = sessionFactory.openSession();
		String hql =  "FROM Emp E";
		try {
			Query query = session.createQuery(hql);
			query.setFirstResult(firstResult); 
			query.setMaxResults(maxResults);
			List<?> results = query.list();
			for (Iterator<?> iterator = results.iterator(); iterator.hasNext();){
				Emp l = (Emp) iterator.next();
				System.out.println(l); 			
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static void in_Query(ArrayList<String> fNameList) {
		Session session = sessionFactory.openSession();
		//ArrayList<String> fNameL = fNameList;
		
		String hql = "FROM Emp E WHERE E.firstName IN (:fNameL)";
		try {
			Query query = session.createQuery(hql);
			query.setParameter("fNameL", fNameList);
			List<?> results = query.list();
			for (Iterator<?> iterator = results.iterator(); iterator.hasNext();){
				Emp l = (Emp) iterator.next();
				System.out.println(l);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
