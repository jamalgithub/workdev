package com.tutorialspoint.hibernate;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

    //XML based configuration
    private static SessionFactory sessionFactory;
     
    //Annotation based configuration
    private static SessionFactory sessionAnnotationFactory;
     
    //Property based configuration
    private static SessionFactory sessionJavaConfigFactory;
 
    private static SessionFactory build(String cfg) {
        try {
        	Configuration config = new Configuration().configure(cfg);
        	
        	//for hibernate 3
        	//sessionFactory = config.buildSessionFactory();
        	
        	//for hibernate 4        	 
        	 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        	 sessionFactory = config.buildSessionFactory(serviceRegistry);
        	 
        	 return sessionFactory;
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }   
 
    private static SessionFactory buildSessionJavaConfigFactory() {
        try {
        Configuration config = new Configuration();
         
        //Create Properties, can be read from property files too
        Properties props = new Properties();
        props.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        props.put("hibernate.connection.url", "jdbc:mysql://localhost/TestDB");
        props.put("hibernate.connection.username", "pankaj");
        props.put("hibernate.connection.password", "pankaj123");
        props.put("hibernate.current_session_context_class", "thread");
         
        config.setProperties(props);
         
        //we can set mapping file or class with annotation
        //addClass(Employee1.class) will look for resource
        // com/journaldev/hibernate/model/Employee1.hbm.xml (not good)
        /*configuration.addAnnotatedClass(Employee1.class);*/
         
        //for hibernate 3
        //sessionFactory = config.buildSessionFactory();
        
        //for hibernate 4        	 
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
   	 	sessionFactory = config.buildSessionFactory(serviceRegistry);
   	 
        return sessionFactory;
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
     
    public static SessionFactory getSessionFactory(String cfg) {
        if(sessionFactory == null) 
        	sessionFactory = build(cfg);
        return sessionFactory;
    }
     
    public static SessionFactory getSessionAnnotationFactory(String cfg) {
        if(sessionAnnotationFactory == null) 
        	sessionAnnotationFactory = build(cfg);
        return sessionAnnotationFactory;
    }
     
    public static SessionFactory getSessionJavaConfigFactory() {
        if(sessionJavaConfigFactory == null) 
        	sessionJavaConfigFactory = buildSessionJavaConfigFactory();
        return sessionJavaConfigFactory;
    }
     
}