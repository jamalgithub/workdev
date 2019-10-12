package com.madhusudhan.j8.streams.commonops;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.madhusudhan.j8.domain.Employee;
import com.madhusudhan.j8.util.EmployeeUtil;

// Partitioning streams
public class Partitioning {

	List<Employee> employees = EmployeeUtil.createDetailedEmployees();
	
	private void partitionByExecutives() {
		Map<Boolean, List<Employee>> empPartition = 
			employees.stream()
			.collect(Collectors.partitioningBy(Employee::isExecutive));
	
		System.out.println(empPartition);
	}
	
	private void partitioningAndGrouping() {
		Map<Boolean, Map<String, List<Employee>>> execEmployees = 
			employees.stream()
			.collect(Collectors.partitioningBy(Employee::isExecutive, Collectors.groupingBy(Employee::getDepartment)));
		
		for(Boolean b: execEmployees.keySet()){
			System.out.println(b+" --> "+execEmployees.get(b));
		}

	}
	
	private void partitioningMultiLevel() {
		Map<Boolean, Map<Boolean, List<Employee>>> execEmployees = 
			employees.stream()
			.collect(Collectors.partitioningBy(Employee::isExecutive, Collectors.partitioningBy(Employee::isSenior)));
		
		for(Boolean b: execEmployees.keySet()){
			System.out.println(b+" ==> "+execEmployees.get(b));
		}

	}
	
	public static void partitioningByLonger() {
		String []string= "you never know what you have until you clean your room".split(" ");
        Stream<String> distinctWords = Arrays.stream(string).distinct();
        Map<Boolean, List<String>> wordBlocks = distinctWords.collect(Collectors.partitioningBy(str -> str.length() > 4));
        System.out.println("Short words (len <= 4): " + wordBlocks.get(false));
        System.out.println("Long words (len > 4): " + wordBlocks.get(true));
	}
	
	public static void main(String[] args) {
		new Partitioning().partitionByExecutives();
		new Partitioning().partitioningAndGrouping();
		new Partitioning().partitioningMultiLevel();
		Partitioning.partitioningByLonger();
	}
}
