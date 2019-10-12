package com.madhusudhan.j8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class TestStream {
	
	public static void extractDataFromStream() {
		long count = Stream.of(1, 2, 3, 4, 5)
							.filter(i -> i % 2 != 0)
					        .peek(i -> System.out.printf("%d ", i))
					        .map(i -> i * i)
					        .peek(i -> System.out.printf("%d ", i))
					        .count();
		System.out.println("\n"+count);
	}
	
	public static void  sortByLengthThenNaturalReversed() {
		List<String> words = Arrays.asList("follow your heart but take your brain with you".split(" "));
	    Comparator<String> lengthCompare = (str1, str2) -> str1.length() - str2.length();
	    words.stream()
            .distinct()
            .sorted(lengthCompare.thenComparing(String::compareTo).reversed())
            .forEach(System.out::println);
	}

	public static void main(String[] args) {
		extractDataFromStream();
		sortByLengthThenNaturalReversed();		
	}

}
