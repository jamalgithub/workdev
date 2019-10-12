package com.oca.p1;

public interface IntfaceB extends IntfaceA{
	
	default String method1() {
		return "method1 interfaceB";
	}
}
