package com.madhusudhan.j8.streams.commonops;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.madhusudhan.j8.domain.Trade;
import com.madhusudhan.j8.util.TradeUtil;

// Reducing Operation
public class Reducing {
	
	List<Trade> trades = TradeUtil.createTrades();
	List<Integer> ints = Arrays.asList();

	private void tradeInstrumentsList() {
		Optional<String> instList = trades.stream()
			.map(Trade::getInstrument)
			.reduce((a,b) -> a+","+b);
		
		System.out.println(instList);
	}
	
	private void schoolStaff() {
		List<Integer> ints = Arrays.asList(11, 13, 12, 15);
		//int staff = ints.stream().reduce(10, (i,j) -> i+j);
		int staff = ints.stream().reduce(10, Integer::sum);
		
		System.out.println("Total staff: "+staff);		
	}

	private void tradeQuantitySum() {
		Optional<Integer> totalQuantity = trades.stream()
					  .map(Trade::getQuantity)
					  //.reduce((a,b) -> a+b)
					  .reduce(Integer::sum);
		
		System.out.println("Total quantity: "+totalQuantity.get());
	}
	
	public static void main(String[] args) {
		new Reducing().schoolStaff();
		new Reducing().tradeQuantitySum();
		new Reducing().tradeInstrumentsList();
	}

}
