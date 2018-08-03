package com.jamal.javademo.java8;

import java.util.function.Consumer;

public class MyConsumer implements Consumer<Integer>{

	@Override
	public void accept(Integer t) {
		System.out.println("Consumer impl Value::"+t);		
	}

}
