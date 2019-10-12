package com.tutorialspoint.eclipselink.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tutorialspoint.eclipselink.entity.Emp;

public class DeleteEmployee {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("tutorialspoint_JPA");
		EntityManager entitymanager = emfactory.createEntityManager();
		EntityTransaction entitytransaction = entitymanager.getTransaction();
		entitytransaction.begin();
		
		Emp employee=entitymanager.find(Emp.class, 1201);
		entitymanager.remove(employee);
		
		entitytransaction.commit();	   	
	   	entitymanager.close();
	   	emfactory.close();

	}

}
