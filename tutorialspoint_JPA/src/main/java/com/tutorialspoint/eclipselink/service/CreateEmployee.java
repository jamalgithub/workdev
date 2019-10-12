package com.tutorialspoint.eclipselink.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tutorialspoint.eclipselink.entity.Emp;

public class CreateEmployee {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("tutorialspoint_JPA");
		EntityManager entitymanager = emfactory.createEntityManager();
		EntityTransaction entitytransaction = entitymanager.getTransaction();
		entitytransaction.begin();
		
		Emp employee = new Emp(); 
	   	employee.setEid( 1201 );
	   	employee.setEname( "Gopal" );
	   	employee.setSalary( 40000 );
	   	employee.setDeg( "Technical Manager" );
	   	entitymanager.persist(employee);
	   	
	   	entitytransaction.commit();	   	
	   	entitymanager.close();
	   	emfactory.close();
	}

}
