package com.tutorialspoint.eclipselink.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tutorialspoint.eclipselink.entity.Family;
import com.tutorialspoint.eclipselink.entity.Person;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("tutorialspoint_JPA");
		EntityManager entitymanager = emfactory.createEntityManager();
		
		Query q = entitymanager.createQuery("select f from Family f");
		List<Person> list = (List<Person>) ((Family)q.getSingleResult()).getMembers();
		for(Person e:list)
	   	{
	   		System.out.println(e);
	   	}
		
		entitymanager.close();
	   	emfactory.close();

	}

}
