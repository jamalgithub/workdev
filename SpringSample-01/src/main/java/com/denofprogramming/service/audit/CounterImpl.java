package com.denofprogramming.service.audit;

public class CounterImpl implements Counter {

	
	private int count;
	
	
	public void increase() {
		count++;		
	}

	
	public int getCount() {		
		return count;
	}

}
