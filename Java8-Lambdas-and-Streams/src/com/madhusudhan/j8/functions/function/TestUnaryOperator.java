package com.madhusudhan.j8.functions.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class TestUnaryOperator {

	public static void main(String[] args) {
		List<Integer> ell = Arrays.asList(-11, 22, 33, -44, 55);
		System.out.println("Before: " + ell);
		ell.replaceAll(Math::abs);
		System.out.println("After: " + ell);
	}

}
