package com.tutorialspoint.eclipselink.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tutorialspoint.eclipselink.entity.NonTeachingStaff;
import com.tutorialspoint.eclipselink.entity.TeachingStaff;

public class InheritenceType {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("tutorialspoint_JPA");
		EntityManager entitymanager = emfactory.createEntityManager();
		EntityTransaction entitytransaction = entitymanager.getTransaction();
		entitytransaction.begin();
		
		//Teaching staff entity 
	   	TeachingStaff ts1=new TeachingStaff(1, "Gopal", "MSc MEd", "Maths");
	   	TeachingStaff ts2=new TeachingStaff(2, "Manisha", "BSc BEd", "English");
	   	
	    //Non-Teaching Staff entity
	   	NonTeachingStaff nts1=new NonTeachingStaff(3, "Satish", "Accounts");
	   	NonTeachingStaff nts2=new NonTeachingStaff(4, "Krishna", "Office Admin");
		
	    //storing all entities
	   	entitymanager.persist(ts1);
	   	entitymanager.persist(ts2);
	   	entitymanager.persist(nts1);
	   	entitymanager.persist(nts2);
	   	
		entitytransaction.commit();
		entitymanager.close();
	   	emfactory.close();
	}

}
