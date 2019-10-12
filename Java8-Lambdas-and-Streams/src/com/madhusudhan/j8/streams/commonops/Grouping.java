package com.madhusudhan.j8.streams.commonops;

import static java.util.stream.Collectors.groupingBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.madhusudhan.j8.domain.Employee;
import com.madhusudhan.j8.util.EmployeeUtil;

public class Grouping {

	List<Employee> employees = EmployeeUtil.createDetailedEmployees();

	//grouping by department
	private void groupingByDepartment() {
		Map<String, List<Employee>> deptEmployees = employees.stream()
			.collect(Collectors.groupingBy(e -> e.getDepartment()));
		System.out.println(deptEmployees);
	}

	//grouping by city
	private void groupingByCity() {
		Map<String, List<Employee>> cityEmployees = employees.stream()
				.collect(Collectors.groupingBy(Employee::getCity));
			System.out.println(cityEmployees);
	}
	
	// multi level grouping by
	private void groupingByDepartmentAndByCity() {
		Map<String, Map<String, List<Employee>>> deptAndCityEmployees =
				employees.stream()
		.collect(groupingBy(Employee::getDepartment, Collectors.groupingBy(Employee::getCity)));
		System.out.println(deptAndCityEmployees);
	}
	
	// Grouping by list
	private void groupingByList() {
	}

	// Grouping by count
	private void groupingByCount() {
	}
	
	public static void groupStringsByLength() {
		String []string= "you never know what you have until you clean your room".split(" ");
        Stream<String> distinctWords = Arrays.stream(string).distinct();
        Map<Integer, List<String>> wordGroups = distinctWords.collect(Collectors.groupingBy(String::length));
        wordGroups.forEach(
                (count, words) -> {
                     System.out.printf("word(s) of length %d %n", count);
                     words.forEach(System.out::println);
                });
	}

	public static void main(String[] args) {
		new Grouping().groupingByDepartment();
		new Grouping().groupingByCity();
		new Grouping().groupingByDepartmentAndByCity();
		new Grouping().groupingByList();
		new Grouping().groupingByCount();
		Grouping.groupStringsByLength();
	}
}
