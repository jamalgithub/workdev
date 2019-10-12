package com.madhusudhan.j8.lambdas.methodrefs;

interface IMovie {
	public boolean check(int id);
}

public class MethodReferences {

	// Static method reference usage
	public void testMovieStaticMethodRef(int x) {
		IMovie m1 = (i) -> isClassic(i);
		System.out.println(m1.check(x));
		
		IMovie m2 = MethodReferences::isClassic;
		System.out.println(m2.check(x));
	}

	// Instance method reference usage
	private void testMovieInstanceMethodRef(int x) {
		MethodReferences ref = new MethodReferences();
		IMovie m1 = (i) -> isTop10(i);
		System.out.println(m1.check(x));
		
		IMovie m2 = ref::isTop10;
		System.out.println(m2.check(x));
	}

	private void testMovieArbitaryObjectMethod(int x) {
		IMovie m1 = SomeMethodReferences::isComedy;
		System.out.println(m1.check(x));
	}

	public boolean isTop10(int movieId) {
		return movieId > 10 && movieId < 100;
	}

	public static boolean isClassic(int movieId) {
		return movieId < 100;
	}

	public static void main(String[] args) {
		MethodReferences client = new MethodReferences();
		client.testMovieInstanceMethodRef(4);
		
		client.testMovieStaticMethodRef(6);
		
		client.testMovieArbitaryObjectMethod(10);
	}

}

class SomeMethodReferences {
	public static boolean isComedy(int i) {
		return false;
	}
}