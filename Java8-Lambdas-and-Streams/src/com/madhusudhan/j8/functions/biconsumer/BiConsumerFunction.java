package com.madhusudhan.j8.functions.biconsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

import com.madhusudhan.j8.domain.Employee;

// TWO argument function - BiConsumer
public class BiConsumerFunction {

	BiConsumer<Employee, Integer> empBonusConsumer = (emp, bonus) -> System.out.printf("Employee %s is set of %d pct of bonus\n", emp, bonus);

	BiConsumer<Employee, Integer> empSalaryHikeConsumer = (emp, sal) -> System.out.printf("Employee %s is receiving %d hike in salary\n", emp, sal);

	BiConsumer<Employee, Integer> empBonusAndHikeConsumer = empBonusConsumer.andThen(empSalaryHikeConsumer);

	private void testBiConsumer(Employee emp, Integer bonus, Integer salaryHike) {
		empBonusConsumer.accept(emp, bonus);
		empSalaryHikeConsumer.accept(emp, salaryHike);
		empBonusAndHikeConsumer.accept(emp, salaryHike);
	}

	public static void main(String[] args) {
		Employee emp = new Employee(10);
		int bonus = 5;
		int salaryHike = 15;
		new BiConsumerFunction().testBiConsumer(emp, bonus, salaryHike);
		
		BiConsumer<List<Integer>, Integer> listAddElement = List::add;
		List aList = new ArrayList();
		listAddElement.accept(aList, 10);
		System.out.println(aList);
	}
}
