package com.madhusudhan.j8.functions.supplier;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

class SupplierTest {
	public static void main(String[] args) {
		Random random = new Random();
		Stream.generate(random::nextBoolean)
			.limit(5)
			.forEach(System.out::println);
		
		//Supplier<String> currentDateTime = () -> LocalDateTime.now().toString();
		Supplier<LocalDateTime> currentDateTime = LocalDateTime::now;
		System.out.println(currentDateTime.get());
		
		Supplier<String> newString = () -> new String();
		System.out.println(newString.get().isEmpty());
	}
}