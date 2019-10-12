package com.madhusudhan.j8.functions.function;

import java.util.function.Function;

import com.madhusudhan.j8.domain.Address;
import com.madhusudhan.j8.domain.Employee;
import com.madhusudhan.j8.domain.Manager;

// Composing Function functions
public class ComposingFunctions {

	//Function<Employee, Manager> managerFinder = (emp) -> getManager(emp);
	Function<Employee, Manager> managerFinder = this::getManager;
	//Function<Manager, Employee> assistantFinder = (manager) -> getPersonalAssistant(manager);
	Function<Manager, Employee> assistantFinder = ComposingFunctions::getPersonalAssistant;

	// andThen method
	private void testAndThen(Employee emp) {
		Function<Employee, Employee> empManagerAssistantFinder = managerFinder.andThen(assistantFinder);
		System.out.println(empManagerAssistantFinder.apply(emp));
	}

	// compose method
	private void testCompose(Manager mgr) {
		Function<Manager, Manager> empFinder = managerFinder.compose(assistantFinder);
		System.out.println(empFinder.apply(mgr));
		
	}

	private void testIdentity() {
		Function<String, String> id = Function.identity();

		String result = id.apply("ID12EFL");

		System.out.println("Result: " + result);
	}

	private static Employee getPersonalAssistant(Manager manager) {
		return manager.getPersonalAssistant();
	}

	private Manager getManager(Employee emp) {
		return emp.getManager();
	}

	public static void main(String[] args) {
		ComposingFunctions client = new ComposingFunctions();
		Employee emp = new Employee(1);
		Manager mgr = new Manager("ahmed");
		emp.setManager(mgr);
		mgr.setPersonalAssistant(emp);
		
		client.testAndThen(emp);
		client.testCompose(mgr);
		client.testIdentity();
	}

	private Address getAddress(Employee employee) {
		return employee.getAddress();
	}

	private Employee getEmployee(int id) {
		return new Employee(id);
	}

}
