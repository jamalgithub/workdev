package com.madhusudhan.j8.functions.consumer;

import java.util.stream.Stream;
import java.util.function.Consumer;

class ConsumerUse {
	public static void main(String[] args) {
		Stream<String> strings = Stream.of("hello", "world");
		Consumer<String> upper = str -> System.out.println(str.toUpperCase());
		Consumer<String> printString = System.out::println;
		Consumer<String> printUpper = upper.andThen(printString);
		strings.forEach(printUpper);
	}
}