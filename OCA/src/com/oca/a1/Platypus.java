package com.oca.a1;

class Mammal {
	public Mammal(int age) {
		System.out.print("Mammal");
	}
}

public class Platypus extends Mammal {
	public Platypus() {
		super(2);
		System.out.print("Platypus");
	}

	public static void main(String[] args) {
		new Mammal(5);
	}
}

class Rodent {
	protected static Integer chew() throws Exception {
		System.out.println("Rodent is chewing");
		return 1;
	}
}

class Beaver extends Rodent {
	public static Number chew() throws RuntimeException {
		System.out.println("Beaver is chewing on wood");
		return 2;
	}
}