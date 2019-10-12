package com.madhusudhan.j8.basics.examplelambdas;

import java.util.concurrent.Callable;

import com.madhusudhan.j8.domain.Trade;

//Example Lambdas
public class Runnables {

	public void methodAcceptingRunnable(Runnable r) {
		r.run();
	}

	public void methodAcceptingCallable(Callable<?> c) {
		try {
			System.out.println(c.call());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Runnables client = new Runnables();
		
		Runnable runnable = () -> System.out.println("Hello, Lambda");
		client.methodAcceptingRunnable(runnable);

		client.methodAcceptingRunnable(() -> {
			System.out.println("Complex lambda");
			persist();
			email();
		});

		Callable<String> callable = () -> "Hello, Callable";
		client.methodAcceptingCallable(callable);

		client.methodAcceptingCallable(() -> {
			return "Hello!";
		});

	}

	private static void email() {
	}

	private static void persist() {
	}

	interface Tradable<Trade> {
		boolean check(Trade t);
	};

	Tradable<Trade> bigTradeLambda = (trade) -> trade.isBigTrade();

	Tradable<Trade> ibmTradeLambda = (trade) -> trade.getInstrument().equals("IBM");
}
