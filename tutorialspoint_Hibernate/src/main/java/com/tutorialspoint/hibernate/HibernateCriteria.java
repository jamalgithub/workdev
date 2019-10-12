package com.tutorialspoint.hibernate;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.tutorialspoint.hibernate.pojoAnnotation.Emp;

public class HibernateCriteria {
	private static SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory("hibernate-criteria.cfg.xml");
	
	public static void main(String[] args) {	
        	    	    
	    HibernateCriteria HC = new HibernateCriteria();

	    /* Add few employee records in database */
	    Integer empID1 = HC.addEmployee("Zara", "Ali", 2000);
	    Integer empID2 = HC.addEmployee("Daisy", "Das", 5000);
	    HC.addEmployee("John", "Paul", 5000);
	    HC.addEmployee("Mohd", "Yasee", 3000);	    
	    
	    /* List down all the employees */
	    HC.listEmployees(2500);
	    
	    /* Load a detached Emp and List it down */
	    System.out.println(HC.loadEmployee(empID1));

	    /* Update an employee */
	    HC.updateEmployee(empID2, 12000);
	    
	    /* Load a detached Emp and List it down */
	    System.out.println(HC.loadEmployee(empID2));
	    
	    /* Print Total employee's count */	    
	    System.out.println("Total Coint: " + HC.countEmployee());

	    /* Print Toatl salary */
	    System.out.println("Total Salary: " + HC.totalSalary());
	    
	    /* Update an employee */
	    HC.updateEmployee(empID2, 12500);
	    	   
	    sessionFactory.close();
	}
	
	/**
	 *  Method to CREATE an employee in the database 
	 */
	public Integer addEmployee(String fname, String lname, int salary){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Integer employeeID = null;
		try{
			tx = session.beginTransaction();
			Emp employee = new Emp(fname, lname, salary);
			employeeID = (Integer) session.save(employee); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) 
				tx.rollback();
			e.printStackTrace(); 
		}finally{
			session.close();
		}
      return employeeID;
   }
	
	/**
	 *  Method to update an employee by id
	 */
	public void updateEmployee(int id, int salary){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Emp emp = null;
		try{
			tx = session.beginTransaction();
			emp = (Emp) session.get(Emp.class, id);
			emp.setSalary(salary);
			session.update(emp);
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) 
				tx.rollback();
			e.printStackTrace(); 
		}finally{
			session.close();
		}
   }
	
	/**
	 * load an Emp by id
	 * @param id
	 * @return persistent Emp
	 */
	public Emp loadEmployee(int id){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Emp emp = null;
		try{
			tx = session.beginTransaction();
			emp = (Emp) session.get(Emp.class, id);
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) 
				tx.rollback();
			e.printStackTrace(); 
		}finally{
			session.close();
		}		
		return emp;
	}
	
	/**
	 * 
	 * @param salary
	 * @return List
	 */
	public List<?> listEmployeesGt(int salary) {
		Session session = sessionFactory.openSession();
		List<?> employees = null;
		try{
			Criteria cr = session.createCriteria(Emp.class);
			// Add restriction.
			cr.add(Restrictions.gt("salary", salary));
			employees = cr.list();								
		}catch (HibernateException e) {			
			e.printStackTrace(); 
		}finally{
			session.close();
		}
		return employees;
	}
	
	/**
	 * print a list of Emp
	 * @param employees
	 */
	public void printListEmployees(List<?> employees){
		for (Iterator<?> iterator = employees.iterator(); iterator.hasNext();){
			Emp employee = (Emp) iterator.next(); 
			System.out.println(employee);
		}
	}
	
	/**
	 *  Method to  READ all the employees having salary more than salary 
	 */
	public void listEmployees(int salary){
		Session session = sessionFactory.openSession();
		try{
			Criteria cr = session.createCriteria(Emp.class);
			// Add restriction.
			cr.add(Restrictions.gt("salary", salary));
			List<?> employees = cr.list();
			
			for (Iterator<?> iterator = employees.iterator(); iterator.hasNext();){
				Emp employee = (Emp) iterator.next(); 
				System.out.println(employee); 
			}
		}catch (HibernateException e) {			
			e.printStackTrace(); 
		}finally{
			session.close();
		}
   }
	
	/**
	 *  Method to calculate total number of Emp records 
	 */
	public Long countEmployee(){
		Session session = sessionFactory.openSession();
		long res = 0;
		try{
			Criteria cr = session.createCriteria(Emp.class);
			// To get total row count.
			cr.setProjection(Projections.rowCount());
			List<?> rowCount = cr.list();
			res = (Long) rowCount.get(0);
		}catch (HibernateException e) {			
			e.printStackTrace(); 
		}finally{
			session.close();
		}
		return res;
	}
	
	/**
	 * Method to calculate sum of salaries 
	 */
	public long totalSalary(){
		Session session = sessionFactory.openSession();
		long res = 0;
		try{
			Criteria cr = session.createCriteria(Emp.class);
			// To get total salary.
			cr.setProjection(Projections.sum("salary"));
			List<?> totalSalary = cr.list();
			res = (Long) totalSalary.get(0);
		}catch (HibernateException e) {
			e.printStackTrace(); 
		}finally{
			session.close();
		}
		return res;
   }
	
	/**
	 * Restrictions with Criteria
	 * @return Criteria
	 * @param Criteria
	 */
	public static Criteria Restrictions_Criteria(Criteria cr) {
		cr.add(Restrictions.eq("salary", 2000));	
	    // To get records having salary less than 2000
	    cr.add(Restrictions.lt("salary", 2000));
	    // Case sensitive form of the above restriction.
	    cr.add(Restrictions.ilike("firstName", "zara%"));
	    // To get records having salary in between 1000 and 2000
	    cr.add(Restrictions.between("salary", 1000, 2000));
	    // To check if the given property is null
	    cr.add(Restrictions.isNull("salary"));
	    // To check if the given property is not null
	    cr.add(Restrictions.isNotNull("salary"));
	    // To check if the given property is empty
	    cr.add(Restrictions.isEmpty("salary"));
	    // To check if the given property is not empty
	    cr.add(Restrictions.isNotEmpty("salary"));
	    
	    Criterion salary = Restrictions.gt("salary", 2000);
	    Criterion name = Restrictions.ilike("firstNname","zara%");	    	  

	    // To get records matching with AND conditions
	    LogicalExpression andExp = Restrictions.and(salary, name);
	    cr.add( andExp );
		return cr;
	}

	/**
	 * Pagination using Criteria
	 * @return Criteria
	 * @param Criteria
	 */
	public static Criteria Pagination_Criteria(Criteria cr) {
		cr.setFirstResult(1);
	    cr.setMaxResults(10);
		return cr;
	}
	
	/**
	 * Sorting the Results
	 * @return Criteria
	 * @param Criteria
	 */
	public static Criteria Sorting_Results(Criteria cr) {
		// To sort records in descening order
	    cr.addOrder(Order.desc("salary"));
	    // To sort records in ascending order
	    cr.addOrder(Order.asc("salary"));
		return cr;
	}

	/**
	 * Projections & Aggregations
	 * @return Criteria
	 * @param Criteria
	 */
	public static Criteria Projections_Aggregations(Criteria cr) {
		// To get total row count.
	    cr.setProjection(Projections.rowCount());
	    // To get average of a property.
	    cr.setProjection(Projections.avg("salary"));
	    // To get distinct count of a property.
	    cr.setProjection(Projections.countDistinct("firstName"));
	    // To get maximum of a property.
	    cr.setProjection(Projections.max("salary"));
	    // To get minimum of a property.
	    cr.setProjection(Projections.min("salary"));
	    // To get sum of a property.
	    cr.setProjection(Projections.sum("salary"));
		return cr;
	}
		
}
