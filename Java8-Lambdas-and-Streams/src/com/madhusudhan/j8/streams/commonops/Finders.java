package com.madhusudhan.j8.streams.commonops;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.madhusudhan.j8.domain.Trade;
import com.madhusudhan.j8.util.TradeUtil;

// Finding and Matching methods
public class Finders {

	List<Trade> trades = TradeUtil.createTrades();
	
	private void display() {
		trades.stream().forEach(System.out::println);
	}
	
	private void testFindFirst() {

		Optional<Trade> firstTrade = trades.stream()
			.filter(Trade::isBigTrade)
			.findFirst();
		
		System.out.println("First trade: "+firstTrade.get());
	}
	
	private void testFindAny() {
		Optional<Trade> anyTrade = trades.stream()
				.filter(Trade::isBigTrade)
				.findAny();
			
		System.out.println("Any trade: "+anyTrade.get());
		
	}
	
	private void testAnyMatch() {
		boolean rottenTrade = trades.stream()
				.anyMatch(t -> t.getStatus().equals("CANCEL"));
		
		System.out.println("AnyMatch trade?:"+rottenTrade);
	}
	
	private void testAllMatch() {
		boolean ibmTrade = trades.stream()
				.allMatch(t -> t.getInstrument().equals("IBM"));
		
		System.out.println("AllMatch trade?:"+ibmTrade);	
	}
	
	private void testNoneMatch() {
		
		boolean cancelledTrade = trades.stream()
				.noneMatch(((Predicate<Trade>)(Trade::isOpen)).negate());
		
		System.out.println("NoneMatch trade?: "+cancelledTrade);
	}
	
	public static void TestMatch() {
		 // Average temperatures in Concordia, Antarctica in a week in October 2015
        boolean anyMatch = IntStream.of(-56, -57, -55, -52, -48, -51, -49).anyMatch(temp -> temp > 0);
        System.out.println("anyMatch(temp -> temp > 0): " + anyMatch);
 
        boolean allMatch = IntStream.of(-56, -57, -55, -52, -48, -51, -49).allMatch(temp -> temp > 0);
        System.out.println("allMatch(temp -> temp > 0): " + allMatch);
 
        boolean noneMatch = IntStream.of(-56, -57, -55, -52, -48, -51, -49).noneMatch(temp -> temp > 0);
        System.out.println("noneMatch(temp -> temp > 0): " + noneMatch);
	}
	
	public static void TestFind() {
		Method[] methods = Stream.class.getMethods();
	    Optional<String> methodName = Arrays.stream(methods)	    			
	                .map(method -> method.getName())
	                .filter(name -> name.endsWith("Match"))
	                .peek(s -> System.out.printf("%s ",s))
	                .sorted()
	                .findFirst();
	    System.out.println("\nResult: " + methodName.orElse("No suitable method found"));
	}
	
	public static void main(String[] args) {
		new Finders().display();
		new Finders().testFindAny();
		new Finders().testFindFirst();
		new Finders().testAnyMatch();
		new Finders().testAllMatch();
		new Finders().testNoneMatch();
		
		Finders.TestMatch();
		Finders.TestFind();
	}
	
}
