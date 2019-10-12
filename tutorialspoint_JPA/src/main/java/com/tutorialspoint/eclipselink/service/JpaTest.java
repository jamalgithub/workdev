package com.tutorialspoint.eclipselink.service;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;

import com.tutorialspoint.eclipselink.entity.Family;
import com.tutorialspoint.eclipselink.entity.Job;
import com.tutorialspoint.eclipselink.entity.Person;


public class JpaTest {
	private static final String PERSISTENCE_UNIT_NAME = "tutorialspoint_JPA";
	private EntityManagerFactory factory;
	
	@Before
	public void setUp() throws Exception {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();		
		em.getTransaction().begin();
		
		Query q = em.createQuery("select m from Person m");
		boolean createNewEntries = (q.getResultList().size() == 0);
		
		if (createNewEntries) {
			assertTrue(q.getResultList().size() == 0);
			Family family = new Family();
			family.setDescription("Family for the Knopfs");
			em.persist(family);
			for (int i = 0; i < 10; i++) {
				Person person = new Person();
				person.setFirstName("Jim_" + (i+1));
				person.setLastName("Knopf_" + (i+1));
				person.setFamily(family);
				for (int j = 0; j < 3; j++) {
					Job job = new Job();
					job.setSalery(1000 *(i+1)*(j+1));
					job.setJobDescr("Job-"+(i+1)+"-"+(j+1));					
					em.persist(job);
					person.getJobList().add(job);
				}
				em.persist(person);
				family.getMembers().add(person);				
			}
		}
	
		em.getTransaction().commit();		
	    em.close();
	
	}
	
	@Test	
	public void checkPerson() {
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createQuery("select m from Person m");		
		assertTrue(q.getResultList().size() == 10);
		
		em.close();
	}
	
	@Test
	public void checkFamily() {
		EntityManager em = factory.createEntityManager();
		
		Query q = em.createQuery("select f from Family f");		
		assertTrue(q.getResultList().size() == 1);
		assertTrue(((Family)q.getSingleResult()).getMembers().size() == 10);				
		
		em.close();
	}
	
	@Test(expected = javax.persistence.NoResultException.class)
	public void deletePerson() {
		EntityManager em = factory.createEntityManager();		
		em.getTransaction().begin();
		
		Query q = em.createQuery("SELECT p FROM Person p WHERE p.firstName = :firstName AND p.lastName = :lastName");
		q.setParameter("firstName", "Jim_1");
		q.setParameter("lastName", "Knopf_!");
		Person user = (Person) q.getSingleResult();
		em.remove(user);
		
		em.getTransaction().commit();		
		em.close();
	}
}
