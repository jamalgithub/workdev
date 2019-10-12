package com.madhusudhan.j8.functions.predicate;

import java.util.function.Predicate;

// java.util.function.Predicate functional interface
public class PredicateFunction {

	Predicate<Employee> bonusLambda = (emp) -> emp.getRatings() > 10;
	Predicate<Employee> execLambda = emp -> emp.getId().startsWith("E99");

	Predicate<String> emptyString = s -> s.isEmpty();

	public static void main(String[] args) {
		PredicateFunction client = new PredicateFunction();
		Employee employee = new Employee("E99");
		employee.setRatings(5);
		System.out.println(client.bonusLambda.test(employee));
		System.out.println(client.execLambda.test(employee));
		System.out.println(client.emptyString.test("jamal"));
	}

}
