package com.madhusudhan.j8.basics.creatinglambdas;

public class CreatingLambdas {
	
	interface Greeting{
		public String sayHello(String h);
	}

	public void testGreting(String a, Greeting g) {
		String result = g.sayHello(a);
		System.out.println("Result: "+result);
	}
	
	public static void main(String[] args) {
		new CreatingLambdas().testGreting("Jamal", (String s) -> {return "Hello, " + s;});
		new CreatingLambdas().testGreting("Adil", (String s) -> "Hello, " + s);
		new CreatingLambdas().testGreting("", (String s) -> !s.isEmpty()? "Hello, " + s : "You miss something");
	}

}
