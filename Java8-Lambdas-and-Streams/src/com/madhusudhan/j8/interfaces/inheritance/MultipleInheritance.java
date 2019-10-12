package com.madhusudhan.j8.interfaces.inheritance;

// Multiple Inheritance

interface Engine {
	default String model(int id) {
		return "DEFAULT ENGINE";
	}
}

interface Vehicle extends Engine {
	default String model(int id) {
		return "DEFAULT VEHICLE";
	}
}

// Derived interfaces or sub-interfaces take higher precedence than the
// interfaces higher-up in the inheritance hierarchy.
class Car implements Engine, Vehicle {
	public String model(int id) {
		// return Engine.super.model(id);
		return Vehicle.super.model(id);
	}
}

public class MultipleInheritance {

	public static void main(String[] args) {
		ClassD d = new ClassD();
		System.out.println(d.model(1));

		Car car = new Car();
		System.out.println(car.model(2));
		
		C c = new D();
		c.foo();
	}

}

class ClassC {

	public void methodC() {
	}

	public String model(int id) {
		return "DEFAULT ClassC";
	}
}

class ClassD extends ClassC implements Vehicle {

	public int test() {
		return 0;
	}
}

interface A {
    default void foo() { System.out.println("hello from A"); }
}
interface B extends A {
    default void foo() { System.out.println("hello from B"); }
}

interface C extends A {
}

class D implements B, C {
}
