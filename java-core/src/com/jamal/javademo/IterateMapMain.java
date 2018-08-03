package com.jamal.javademo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class IterateMapMain {

	public static void main(String[] args) {
		// HashMap with Country as key and capital as value
		HashMap<String, String> countryCapitalMap = new HashMap<String, String>();
		countryCapitalMap.put("India", "Delhi");
		countryCapitalMap.put("Japan", "Tokyo");
		countryCapitalMap.put("France", "Paris");
		countryCapitalMap.put("Russia", "Moscow");

		// Iterating Using keySet() and for each loop
		System.out.println("Iterating Using keySet() and for each loop");
		for (String countryKey : countryCapitalMap.keySet()) {
			System.out.println("Country:" + countryKey + " and  Capital:" + countryCapitalMap.get(countryKey));

		}
		System.out.println("-----------------------------");

		// Iterating Using keySet() and java iterator
		System.out.println("Iterating Using keySet() and java Iterator");
		Iterator<String> countryKeySetIterator = countryCapitalMap.keySet().iterator();
		while (countryKeySetIterator.hasNext()) {
			String countryKey = (String) countryKeySetIterator.next();
			System.out.println("Country:" + countryKey + " and Capital:" + countryCapitalMap.get(countryKey));

		}
		System.out.println("-----------------------------");

		// Iterating Using entrySet() and for each loop
		System.out.println("Iterating Using entrySet() and for each loop");
		for (Entry<String, String> entry : countryCapitalMap.entrySet()) {
			System.out.println("Country:" + entry.getKey() + " and  Capital:" + entry.getValue());

		}
		System.out.println("-----------------------------");

		// Iterating Using entrySet() and java iterator
		System.out.println("Iterating Using entrySet() and and java Iterator");
		Iterator<Entry<String, String>> entryIterator = countryCapitalMap.entrySet().iterator();
		while (entryIterator.hasNext()) {
			Entry<String, String> entry = entryIterator.next();
			System.out.println("Country:" + entry.getKey() + " and  Capital:" + entry.getValue());

		}
		System.out.println("-----------------------------");

	}

}
