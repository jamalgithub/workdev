package com.tutorialspoint.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.stat.Statistics;

import com.tutorialspoint.hibernate.pojoAnnotation.Emp;

public class HibernateCahe {
	private static SessionFactory sessionFactory;
	
	public static void main(String[] args) {
		System.out.println("Temp Dir:"+System.getProperty("java.io.tmpdir"));
		
		sessionFactory = HibernateUtil.getSessionAnnotationFactory("hibernate-cache.cfg.xml");
		
		Statistics stats = sessionFactory.getStatistics();
        System.out.println("Stats enabled="+stats.isStatisticsEnabled());
        stats.setStatisticsEnabled(true);
        System.out.println("Stats enabled="+stats.isStatisticsEnabled());
        
		Session session = sessionFactory.openSession(); 
		Session otherSession = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
        Transaction otherTransaction = otherSession.beginTransaction();
		
        printStats(stats, 0);
        
        Emp emp = (Emp) session.load(Emp.class, 1);
        printData(emp, stats, 1);
         
        emp = (Emp) session.load(Emp.class, 1);
        printData(emp, stats, 2);
         
        //clear first level cache, so that second level cache is used
        session.evict(emp);
        emp = (Emp) session.load(Emp.class, 1);
        printData(emp, stats, 3);
         
        emp = (Emp) session.load(Emp.class, 3);
        printData(emp, stats, 4);
         
        emp = (Emp) otherSession.load(Emp.class, 1);
        printData(emp, stats, 5);
         
        //Release resources
        transaction.commit();
        otherTransaction.commit();
        sessionFactory.close();
        		
	}
	
	private static void printStats(Statistics stats, int i) {
        System.out.println("***** " + i + " *****");
        System.out.println("Fetch Count=" + stats.getEntityFetchCount());
        System.out.println("Second Level Hit Count=" + stats.getSecondLevelCacheHitCount());
        System.out.println("Second Level Miss Count=" + stats.getSecondLevelCacheMissCount());
        System.out.println("Second Level Put Count=" + stats.getSecondLevelCachePutCount());
    }
 
    private static void printData(Emp emp, Statistics stats, int count) {
        System.out.println(count + ":: Name=" + emp.getFirstName() + ", Zipcode="+emp.getLastName());
        printStats(stats, count);
    }

}
