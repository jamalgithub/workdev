package com.jamal.service;

public class RandomizerRequestScope {
	private int randomNumber = 5;
	
	public void generateRandomNumber() {
		this.randomNumber = (int) (Math.random() * 99999);
	}

	public int getRandomNumber() {
		return randomNumber;
	}

}
