package com.madhusudhan.j8.lambdas.methodrefs;

import java.util.Arrays;

interface StringArray {
	String[] create(int size);
}

interface MovieFactory3 {
	public Movie[] create(int size);
}

public class ArrayReferences {

	private void testArrayConstructorReferences(int i) {
		StringArray sArray = (size) -> new String[size];
		StringArray sArray2 = String[]::new;
		
		System.out.println(Arrays.toString(sArray2.create(i)));
		
		MovieFactory3 m = Movie[]::new;
		System.out.println(Arrays.toString(m.create(i)));
	}

	public static void main(String[] args) {
		ArrayReferences arrRef = new ArrayReferences();
		arrRef.testArrayConstructorReferences(3);
	}

}
