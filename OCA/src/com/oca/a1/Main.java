package com.oca.a1;

import java.util.Arrays;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] cmd) {
		
		short x = 5;
		System.out.println(test(i -> i == 5));
		// System.out.println(test(i -> {i == 5;}));
		System.out.println(test((i) -> i == 5));
		// System.out.println(test((int i) -> i == 5);
		// System.out.println(test((int i) -> {return i == 5;}));
		System.out.println(test((i) -> {
			return i == 5;
		}));
	}

	private static boolean test(Predicate<Integer> p) {
		return p.test(5);
	}

}
