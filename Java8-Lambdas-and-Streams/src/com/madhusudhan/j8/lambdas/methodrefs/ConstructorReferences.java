package com.madhusudhan.j8.lambdas.methodrefs;

interface MovieFactory {
	public Movie create(int id);
}

interface MovieFactory2 {
	public Movie create(int id, String s);
}

public class ConstructorReferences {

	MovieFactory m1 = i -> new Movie(i);
	MovieFactory m2 = Movie::new;

	MovieFactory2 m3 = (i, n) -> new Movie(i, n);
	MovieFactory2 m4 = Movie::new;

	public static void main(String[] args) {
		ConstructorReferences client = new ConstructorReferences();
		System.out.println(client.m1.create(1));
		System.out.println(client.m2.create(2));
		
		System.out.println(client.m3.create(3, "jamal"));
		System.out.println(client.m4.create(4, "adil"));		
	}

}

class Movie {
	private int id;
	private String name;
	
	// Constructor 1
	public Movie(int id) {
		this.id=id;
	}

	// Constructor 2
	public Movie(int id, String name) {
		this(id);
		this.name = name;
	}

	@Override
	public String toString() {
		return "["+this.id+", "+this.name+"]";
	}
	
}