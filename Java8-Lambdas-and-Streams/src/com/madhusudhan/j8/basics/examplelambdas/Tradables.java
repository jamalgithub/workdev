package com.madhusudhan.j8.basics.examplelambdas;

import com.madhusudhan.j8.domain.Trade;

interface ITradable<Trade> {
	boolean check(Trade t);
}

public class Tradables {
	
	public static void main(String[] args) {
		Trade trade = new Trade("Trade1", 10000, "OPEN");

		ITradable<Trade> bigTrade = (Trade t) -> t.getQuantity() > 1000000;
		System.out.println(bigTrade.check(trade));

		ITradable<Trade> openTrade = (t) -> t.getStatus().equals("OPEN");
		System.out.println(openTrade.check(trade));
	}
}
