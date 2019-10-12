package com.tutorialspoint.eclipselink.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tutorialspoint.eclipselink.entity.Emp;

public class UpdateEmployee {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("tutorialspoint_JPA");
		EntityManager entitymanager = emfactory.createEntityManager();
		EntityTransaction entitytransaction = entitymanager.getTransaction();
		entitytransaction.begin();
		
		Emp employee=entitymanager.find(Emp.class, 1201);
		
		//before update
	   	System.out.println(employee);
	   	employee.setSalary( 46000 );
	   	
	   	entitytransaction.commit();
	   	//after update
	   	System.out.println(employee);
	   	
	   	entitymanager.close();
	   	emfactory.close();
	}

}
