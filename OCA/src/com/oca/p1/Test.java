package com.oca.p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		// castType();
		Vehicle car = new Car("BMW");
		System.out.println(car.getBrand());
		System.out.println(car.speedUp());
		System.out.println(car.slowDown());
		System.out.println(car.turnAlarmOn());
		System.out.println(car.turnAlarmOff());
		System.out.println(car.turnOn());
		// System.out.println(car.turnOff());
		System.out.println(Vehicle.getHorsePower(2500, 480));

		List<String> list = new ArrayList<String>();
		Consumer<String> c1 = list::add;
		Consumer<String> c2 = System.out::println;
		Consumer<String> c3 = c1.andThen(c2);

		Stream<String> st1 = Stream.of("a", "b", "c");
		Predicate<? super String> predicate = e -> e.contains("b");
		List<String> elements = st1.filter(predicate).collect(Collectors.toList());
		Optional<String> anyElement = elements.stream().findAny();
		Optional<String> firstElement = elements.stream().findFirst();
		System.out.println(firstElement.isPresent() ? firstElement.get():null);

		List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		// Predicate<Integer> predicate = n -> true
		// n is passed as parameter to test method of Predicate interface
		// test method will always return true no matter what value n has.

		System.out.println("Print all numbers:");

		// pass n as parameter
		eval(list2, n -> true);

		// Predicate<Integer> predicate1 = n -> n%2 == 0
		// n is passed as parameter to test method of Predicate interface
		// test method will return true if n%2 comes to be zero

		System.out.println("\nPrint even numbers:");
		eval(list2, n -> n % 2 == 0);

		// Predicate<Integer> predicate2 = n -> n > 3
		// n is passed as parameter to test method of Predicate interface
		// test method will return true if n is greater than 3.

		System.out.println("\nPrint numbers greater than 3:");
		eval(list2, n -> n > 3);
		
		System.out.println("\n");
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		List<Integer> squaresList = numbers.stream().map(i -> i*i).distinct().sorted().collect(Collectors.toList());
		squaresList.stream().forEach(s -> System.out.println(s));
		List<Integer> filtered = squaresList.stream().filter(s -> s%2==0).collect(Collectors.toList());
		filtered.stream().forEach(System.out::print);
		
		numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

		IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println("\n\nHighest number in List : " + stats.getMax());
		System.out.println("Lowest number in List : " + stats.getMin());
		System.out.println("Sum of all numbers : " + stats.getSum());
		System.out.println("Average of all numbers : " + stats.getAverage());
	}

	private static void castType() {
		float value1 = 102;
		float value2 = (int) 102.0;
		// float value3 = 1f * 0.0;
		float value4 = 1f * (short) 0.0;
		// float value5 = 1f * (boolean)0;
	}

	private static void eval(List<Integer> list, Predicate<Integer> predicate) {

		for (Integer n : list) {

			if (predicate.test(n)) {
				System.out.print(n + " ");
			}
		}
	}

}
