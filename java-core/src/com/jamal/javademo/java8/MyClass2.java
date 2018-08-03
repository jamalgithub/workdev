package com.jamal.javademo.java8;

public class MyClass2 {

	public static void main(String[] args) {
		Interface1 i1 = (str) -> {
			System.out.println("Implemtaion of method1");
		};
		i1.method1("hello!");
	}

}
