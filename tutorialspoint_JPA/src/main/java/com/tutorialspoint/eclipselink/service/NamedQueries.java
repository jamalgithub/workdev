package com.tutorialspoint.eclipselink.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tutorialspoint.eclipselink.entity.Emp;

public class NamedQueries {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("tutorialspoint_JPA");
		EntityManager entitymanager = emfactory.createEntityManager();
		
		System.out.println("------------- find By Id -------------");
		Query query = entitymanager.createNamedQuery("Emp.findById");
		query.setParameter("id", 1204);
		List<Emp> listfindById = query.getResultList( );
	   	for( Emp e:listfindById )
	   	{
	   		System.out.print("Employee ID :"+e.getEid( ));
	   		System.out.println("\t Employee Name :"+e.getEname( ));
	   	}
		
	   	System.out.println("------------- find By Name -------------");
	   	query = entitymanager.createNamedQuery("Emp.findByName");
	   	query.setParameter("name", "Satish");
	   	List<Emp> listfindByName = query.getResultList( );
	   	for( Emp e:listfindByName )
	   	{
	   		System.out.print("Employee ID :"+e.getEid( ));
	   		System.out.println("\t Employee Name :"+e.getEname( ));
	   	}
	   	
		entitymanager.close();
	   	emfactory.close();
	}

}
