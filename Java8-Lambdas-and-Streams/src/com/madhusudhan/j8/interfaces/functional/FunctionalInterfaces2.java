package com.madhusudhan.j8.interfaces.functional;

public class FunctionalInterfaces2 {
	interface Factory {
		Car create(int id);
	}

	// Lambda expression
	//Factory f = id ->  new Car(id);  
	Factory f = Car::new;  

	public static void main(String[] args) {

	}

}
