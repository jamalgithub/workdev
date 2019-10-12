package com.madhusudhan.j8.functions.bipredicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

import com.madhusudhan.j8.domain.Employee;
import com.madhusudhan.j8.domain.Manager;

// TWO argument function: BiPredicate
public class BiPredicateFunction {

	BiPredicate<Employee, Manager> empManagerPredicate = (emp, manager) -> emp.getManager().equals(manager);

	BiPredicate<Employee, Manager> managerHasAssistantPredicate = (emp,	manager) -> manager.getPersonalAssistant().equals(emp);

	BiPredicate<Employee, Manager> isPA = empManagerPredicate.and(managerHasAssistantPredicate);

	BiPredicate<Employee, Manager> isPA2 = empManagerPredicate.or(managerHasAssistantPredicate);

	BiPredicate<Employee, Manager> notAManagerPredicate = empManagerPredicate.negate();

	private void testBiPredicate(Employee emp, Manager manager) {
		System.out.println("Is manager? " + empManagerPredicate.test(emp, manager));
		System.out.println("Is personal assistant? " + managerHasAssistantPredicate.test(emp, manager));						
	}

	private void testNegate(Employee emp, Manager manager) {
		System.out.println("Is not manager to other? " + notAManagerPredicate.test(emp, manager));
	}

	private void testAnd(Employee emp, Manager manager) {
		System.out.println("Is manager and personal assistant each to other? " + isPA.test(emp, manager));
	}

	private void testOr(Employee emp, Manager manager) {
		System.out.println("Is manager or personal assistant each to other? " + isPA2.test(emp, manager));
	}

	public static void main(String[] args) {
		Employee emp = new Employee(99);
		Manager manager = new Manager();
		emp.setManager(manager);
		manager.setPersonalAssistant(emp);
		
		// this returns true because emp's manager is set
		new BiPredicateFunction().testBiPredicate(emp, manager);

		// this returns false, because manager is different
		Manager manager2 = new Manager();
		new BiPredicateFunction().testBiPredicate(emp, manager2);

		// testNegate
		new BiPredicateFunction().testNegate(emp, manager);

		// testAnd
		new BiPredicateFunction().testAnd(emp, manager);
		
		// testOr
		new BiPredicateFunction().testOr(emp, manager);
		
		BiPredicate<List<Integer>, Integer> listContains = List::contains;
		List aList = Arrays.asList(10, 20, 30);
		System.out.println(listContains.test(aList, 21));
	}

}
