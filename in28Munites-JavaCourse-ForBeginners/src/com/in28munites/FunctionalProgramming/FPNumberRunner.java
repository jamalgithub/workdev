package com.in28munites.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FPNumberRunner {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(4,6,8,13,3,15);
		
		//Exercise - Print squares of first 10 numbers!
		//Clue - IntStream.range(1,10)
		fpSquare();
		
		//Arrays.asList("Apple", "Ant", "Bat").stream()
		//Map all of these to lowercase and print them
		fpLowerCase();
		
		//List.of("Apple", "Ant", "Bat").stream()
		//Print the length of each element
		fpLength();
		
		/*
		numbers.stream()
				.forEach( element ->System.out.println(element));*/
		
		//int sum = normalSum(numbers);
		//int sum = fpSum(numbers);
		int sum = fpSumOdd(numbers);
		//int sum = fpSumOdd2(numbers);
			
		System.out.println(sum);

	}
	
	private static void fpSquare() {
		IntStream.range(1, 10)
				.map(e -> e * e)
				.forEach(p -> System.out.println(p));
	}
	
	private static void fpLowerCase() {
		Arrays.asList("Apple", "Ant", "Bat").stream()
											.map(s -> s.toLowerCase())
											.forEach(p -> System.out.println(p));
	}
	
	private static void fpLength() {
		Arrays.asList("Apple", "Ant", "Bat").stream()
											.map(s -> s.length())
											.forEach(p -> System.out.println(p));
//		Arrays.asList("Apple", "Ant", "Bat").stream()
//											.map(s -> s.length())
//											.forEach(p -> System.out.println(p.length()));
	}

	private static int normalSum(List<Integer> numbers) {
		int sum = 0;
		for(int number:numbers) {
			sum += number; 
		}
		return sum;
	}
	
	private static int fpSum(List<Integer> numbers) {
		return numbers.stream().reduce(0, (number1, number2) ->  number1 + number2);
	}
	
	private static int fpSumOdd(List<Integer> numbers) {
		return numbers.stream()											// Lambda Expression is a shortcut for creating a function
				.filter(number -> number % 2 == 1) 						// Intermediate Operation
				.reduce(0, (number1, number2) ->  number1 + number2);   // Terminal Operation : consume the result stream
	}
	
	private static int fpSumOdd2(List<Integer> numbers) {
		return numbers.stream()
				.filter(number -> number % 2 == 1)
				.reduce(0, (number1, number2) ->  {
						return number1 + number2;
					}
				);
	}

}
