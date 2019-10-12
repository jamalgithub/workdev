package com.madhusudhan.j8.functions.primitives;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntPredicate;
import java.util.function.IntToLongFunction;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestPrimitiveFunctions {

	public static void main(String[] args) {
		IntPredicate evenNums = i -> (i % 2) == 0;
		IntStream.range(1, 10).filter(evenNums).forEach(System.out::println);
		
		AtomicInteger ints = new AtomicInteger(0);
		IntStream.generate(ints::incrementAndGet).limit(10).forEach(System.out::println);
		
		IntToLongFunction absInt = Math::abs;
		IntStream intss = IntStream.of(6,-5,4,-3,-8);
		intss.mapToLong(absInt).forEach(System.out::println);
		
		ToIntFunction<String> toIntFunction = Integer::parseInt;
		Stream<String> ss = Stream.of("3","7","1","8");
		ss.mapToInt(toIntFunction).forEach(System.out::println);
	}

}
