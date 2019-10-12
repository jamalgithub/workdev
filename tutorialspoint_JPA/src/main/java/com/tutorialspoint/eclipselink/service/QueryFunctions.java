package com.tutorialspoint.eclipselink.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tutorialspoint.eclipselink.entity.Emp;

public class QueryFunctions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("tutorialspoint_JPA");
		EntityManager entitymanager = emfactory.createEntityManager();

		//Scalar function
		System.out.println("------------- Scalar function -------------");
		Query query = entitymanager.createQuery("Select UPPER(e.ename) from Employee e");
		List<String> list = query.getResultList();		
		for(String e:list)
	   	{
	   		System.out.println("Employee NAME :"+e);
	   	}
		
		//Aggregate function
		System.out.println("------------- Aggregate function -------------");
		query = entitymanager.createQuery("Select MAX(e.salary) from Employee e");
		Double result = (Double) query.getSingleResult();
		System.out.println("Max Employee Salary :" + result);
		
		//Between
		System.out.println("------------- Between -------------");
	   	query = entitymanager.createQuery( "Select e from Employee e where e.salary Between 30000 and 40000" );
	   	List<Emp> listBetween = query.getResultList();
	   	for( Emp e:listBetween )
	   	{
	   		System.out.print("Employee ID :"+e.getEid());
	   		System.out.println("\t Employee salary :"+e.getSalary());
	   	}
	   	
	   	//Like
	   	System.out.println("------------- Like -------------");
	   	query = entitymanager.createQuery("Select e from Employee e where e.ename LIKE 'M%'");
	   	List<Emp> listLike = query.getResultList();
	   	for( Emp e:listLike )
	   	{
	   		System.out.print("Employee ID :"+e.getEid( ));
	   		System.out.println("\t Employee name :"+e.getEname( ));
	   	}
	   	
	   	//Order By
		System.out.println("------------- Order By -------------");
	   	query = entitymanager.createQuery( "Select e from Employee e ORDER BY e.ename ASC" );
	   	List<Emp> listOrderBy = query.getResultList( );
	   	for( Emp e:listOrderBy )
	   	{
	   		System.out.print("Employee ID :"+e.getEid());
	   		System.out.println("\t Employee Name :"+e.getEname());
	   	}
	   	
	   	entitymanager.close();
	   	emfactory.close();
	}

}
