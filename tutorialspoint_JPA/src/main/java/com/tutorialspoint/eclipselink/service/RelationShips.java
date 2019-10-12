package com.tutorialspoint.eclipselink.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tutorialspoint.eclipselink.entity.Clas;
import com.tutorialspoint.eclipselink.entity.Department;
import com.tutorialspoint.eclipselink.entity.Employee;
import com.tutorialspoint.eclipselink.entity.Teacher;

public class RelationShips {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("tutorialspoint_JPA");
		EntityManager entitymanager = emfactory.createEntityManager();
		EntityTransaction entitytransaction = entitymanager.getTransaction();
		entitytransaction.begin();
				
		//OneToMany(entitymanager);
		//ManyToOne(entitymanager);
		//OneToOne(entitymanager);
		ManyToMany(entitymanager);
		
		entitytransaction.commit();	   	
	   	entitymanager.close();
	   	emfactory.close();

	}
	
	/**
	 * Clas ManyToMany Teacher.
	 * table: clas, teacher, teacher_clas
	 */
	public static void ManyToMany(EntityManager entitymanager) {
		System.out.println("------------ Start Clas ManyToMany Teacher --------------");
		
		//Create Clas Entity
	   	Clas clas1=new Clas(0,"1st",null);
	   	Clas clas2=new Clas(0,"2nd",null);
	   	Clas clas3=new Clas(0,"3rd",null);
	   	
	   	//Store Clas
	   	entitymanager.persist(clas1);
	   	entitymanager.persist(clas2);
	   	entitymanager.persist(clas3);
		
	   	//Create Clas Set1
	   	Set<Clas> classSet1 = new HashSet<Clas>();
	   	classSet1.add(clas1);
	   	classSet1.add(clas2);
	   	classSet1.add(clas3);
	   	
	   	//Create Clas Set2
	   	Set<Clas> classSet2 = new HashSet<Clas>();
	   	classSet2.add(clas3);
	   	classSet2.add(clas1);	  
	   			
	   	//Create Clas Set3
	   	Set<Clas> classSet3 = new HashSet<Clas>();
	   	classSet3.add(clas2);	   	
	   	classSet3.add(clas1);
	   	
	   	//Create Teacher Entity
	   	Teacher teacher1 = new Teacher(0,"Satish","Java",classSet1);
	   	Teacher teacher2 = new Teacher(0,"Krishna","Adv Java",classSet2);
	   	Teacher teacher3 = new Teacher(0,"Masthanvali","DB2",classSet3);
	   	
	   	//Store Teacher
	   	entitymanager.persist(teacher1);
	   	entitymanager.persist(teacher2);
	   	entitymanager.persist(teacher3);
	   	
	   	System.out.println("------------ End Clas ManyToMany Teacher --------------");
		
	}

	/**
	 * Department OneToMany Employee.
	 * table: department, employee, department_employee
	 */
	public static void OneToMany(EntityManager entitymanager) {
		System.out.println("------------ Start Department OneToMany Employee --------------");
		
		//Create Employee1 Entity
	   	Employee employee1 = new Employee();
	   	employee1.setEname("Satish");
	   	employee1.setSalary(45000.0);
	   	employee1.setDeg("Technical Writer");
	   							
	   	//Create Employee2 Entity
	   	Employee employee2 = new Employee();
	   	employee2.setEname("Krishna");
	   	employee2.setSalary(45000.0);
	   	employee2.setDeg("Technical Writer");
	   							
	   	//Create Employee3 Entity
	   	Employee employee3 = new Employee();
	   	employee3.setEname("Masthanvali");
	   	employee3.setSalary(50000.0);
	   	employee3.setDeg("Technical Writer");
	   	
	   	//Store Employee
	   	entitymanager.persist(employee1);
	   	entitymanager.persist(employee2);
	   	entitymanager.persist(employee3);
	   	
	   	//Create Employeelist
	   	List<Employee> emplist = new ArrayList<Employee>();
	   	emplist.add(employee1);
	   	emplist.add(employee2);
	   	emplist.add(employee3);
	   	
	   	//Create Department Entity
	   	Department department= new Department();
	   	department.setName("Development");
	   	department.setEmployee(emplist);
	   			
	   	//Store Department
	   	entitymanager.persist(department);
	   	
	   	System.out.println("------------ End Department OneToMany Employee --------------");
	}
	
	/**
	 * Employee ManyToOne Department.
	 * table: department, employee
	 */
	public static void ManyToOne(EntityManager entitymanager) {
		/*
		System.out.println("------------ Start Employee ManyToOne Department --------------");
		 
		//Create Department Entity
	   	Department department = new Department();
	   	department.setName("Development");
	   	//Store Department
	   	entitymanager.persist(department);
	   	
	   	//Create Employee1 Entity
	   	Employee employee1 = new Employee();
	   	employee1.setEname("Satish");
	   	employee1.setSalary(45000.0);
	   	employee1.setDeg("Technical Writer");
	   	employee1.setDepartment(department);
	   	
	   	//Create Employee2 Entity
	   	Employee employee2 = new Employee();
	   	employee2.setEname("Krishna");
	   	employee2.setSalary(45000.0);
	   	employee2.setDeg("Technical Writer");
	   	employee2.setDepartment(department);
	   	
	 	//Create Employee3 Entity
	   	Employee employee3 = new Employee();
	   	employee3.setEname("Masthanvali");
	   	employee3.setSalary(50000.0);
	   	employee3.setDeg("Technical Writer");
	   	employee3.setDepartment(department);
	   	
	   	//Store Employees
	   	entitymanager.persist(employee1);
	   	entitymanager.persist(employee2);
	   	entitymanager.persist(employee3);
	   	
	   	System.out.println("------------ End Employee ManyToOne Department --------------");
	   	*/
	}

	/**
	 * Employee OneToOne Department.
	 * table: department, employee
	 */
	public static void OneToOne(EntityManager entitymanager) {
		/*
		System.out.println("------------ Start Employee Employee OneToOne Department --------------");
		
		//Create Department Entity
	   	Department department = new Department();
	   	department.setName("Development");
	   	
	   	//Store Department
	   	entitymanager.persist(department);
	   	
	   	//Create Employee Entity
	   	Employee employee = new Employee();
	   	employee.setEname("Satish");
	   	employee.setSalary(45000.0);
	   	employee.setDeg("Technical Writer");
	   	employee.setDepartment(department);
	   	
	   	//Store Employee
	   	entitymanager.persist(employee);
	   	
	   	System.out.println("------------ End Employee Employee OneToOne Department --------------");
	   	*/
	}
}
