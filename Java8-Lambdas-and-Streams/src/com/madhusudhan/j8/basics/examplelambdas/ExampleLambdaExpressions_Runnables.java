package com.madhusudhan.j8.basics.examplelambdas;

// Examples using Runnable Lambda Expressions

public class ExampleLambdaExpressions_Runnables {

	private void testRunnable(Runnable runnable) {
		new Thread(runnable).start();
	}

	public static void main(String[] args) throws Exception {
		ExampleLambdaExpressions_Runnables client = new ExampleLambdaExpressions_Runnables();

		Runnable r = () -> System.out.println("Run...");
		
		// 1. Runnables
		client.testRunnable(r);

		// using a simple expression
		client.testRunnable(() -> System.out.println("Running a new Thread..using lambda!"));

		// using a complex code block
		client.testRunnable(() -> {
			System.out.println("Running in a new thread..using complex code block");
			persist();
			email();
		});

	}

	private static void email() {

	}

	private static void persist() {

	}

}
