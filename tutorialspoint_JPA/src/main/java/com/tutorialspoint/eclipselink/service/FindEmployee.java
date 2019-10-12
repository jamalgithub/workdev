package com.tutorialspoint.eclipselink.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tutorialspoint.eclipselink.entity.Emp;

public class FindEmployee {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("tutorialspoint_JPA");
		EntityManager entitymanager = emfactory.createEntityManager();
		
		Emp employee=entitymanager.find(Emp.class, 1201);

		System.out.println("employee ID = "+employee.getEid( ));
	   	System.out.println("employee NAME = "+employee.getEname( ));
	   	System.out.println("employee SALARY = "+employee.getSalary( ));
	   	System.out.println("employee DESIGNATION = "+employee.getDeg( ));
	}

}
