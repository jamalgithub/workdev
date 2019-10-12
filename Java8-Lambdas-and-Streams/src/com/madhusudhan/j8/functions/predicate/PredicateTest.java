package com.madhusudhan.j8.functions.predicate;

import java.util.function.Predicate;

public class PredicateTest {
	public static void main(String[] args) {
		Predicate<String> nullCheck = arg -> arg != null;
		Predicate<String> emptyCheck = arg -> arg.length() > 0;
		Predicate<String> nullAndEmptyCheck = nullCheck.and(emptyCheck);
		String helloStr = "hello";
		System.out.println(nullAndEmptyCheck.test(helloStr));

		String nullStr = null;
		System.out.println(nullAndEmptyCheck.test(nullStr));
	}
}