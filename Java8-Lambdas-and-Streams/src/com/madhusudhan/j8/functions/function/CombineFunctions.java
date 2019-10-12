package com.madhusudhan.j8.functions.function;

import java.util.Arrays;
import java.util.function.Function;

public class CombineFunctions {
	public static void main(String[] args) {
		Function<String, Integer> parseInt = Integer::parseInt;
		Function<Integer, Integer> absInt = Math::abs;
		Function<String, Integer> parseAndAbsInt = parseInt.andThen(absInt);
		Function<String, Integer> parseAndAbsInt2 = absInt.compose(parseInt);

		Arrays.stream("4, -9, 16".split(", ")).map(parseAndAbsInt).forEach(System.out::println);
		Arrays.stream("4, -9, 16".split(", ")).map(parseAndAbsInt2).forEach(System.out::println);
		Arrays.stream("4, -9, 16".split(", ")).map(Function.identity()).forEach(System.out::println);
		
		Function<Integer, Integer> negate = (i -> -i), square = (i -> i * i), negateSquare = negate.compose(square);
		System.out.println(negateSquare.apply(10));
		
		Function<String, Integer> anotherInteger = Integer::new;
		System.out.println(anotherInteger.apply("100"));
	}

}