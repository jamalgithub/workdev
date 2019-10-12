package com.tutorialspoint.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tutorialspoint.hibernate.pojoAnnotation.Course;
import com.tutorialspoint.hibernate.pojoAnnotation.Student;

public class MainManyToMany {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory("hib_annot_many_to_many.cfg.xml").openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			Set<Course> courses = new HashSet<Course>();
			courses.add(new Course("Maths"));
			courses.add(new Course("Computer Science"));

			Student student1 = new Student("Eswar", courses);
			Student student2 = new Student("Joe", courses);
			session.persist(student1);
			session.persist(student2);						

			session.delete(student2);
			transaction.commit();
		} catch (HibernateException e) {
			if(transaction != null)
				transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}
