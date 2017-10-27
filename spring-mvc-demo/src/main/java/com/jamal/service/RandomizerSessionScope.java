package com.jamal.service;

public class RandomizerSessionScope {
	private int randomNumber = 10;
	
	public void generateRandomNumber() {
		this.randomNumber = (int) (Math.random() * 99999);
	}

	public int getRandomNumber() {
		return randomNumber;
	}

}
