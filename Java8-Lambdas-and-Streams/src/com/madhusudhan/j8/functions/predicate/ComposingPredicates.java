package com.madhusudhan.j8.functions.predicate;

import java.util.List;
import java.util.function.Predicate;

import com.madhusudhan.j8.domain.Trade;
import com.madhusudhan.j8.util.TradeUtil;

// Composing or chaining Predicates
public class ComposingPredicates {

	private void testPredicates(Trade trade) {
		
		/* LOGICAL OR */
		Predicate<Trade> newTrade = t -> t.getStatus().equals("NEW");
		Predicate<Trade> cancelledTrade = t -> t.getStatus().equals("CANCEL");
		
		Predicate<Trade> newOrCancelledTrade = newTrade.or(cancelledTrade);
		System.out.println(newOrCancelledTrade.test(trade));
		
		/* LOGICAL AND and OR */
		Predicate<Trade> bigTrade = t -> t.isBigTrade();
		
		Predicate<Trade> newOrCancelledButBigTrade = newTrade.or(cancelledTrade).and(bigTrade);
		System.out.println(newOrCancelledButBigTrade.test(trade));

		/* NEGATE */
		Predicate<Trade> notANewTrade = newTrade.negate();
		System.out.println(notANewTrade.test(trade));
		
		/* EQUALS */
		
		List<Trade> trades = TradeUtil.createTrades();
		
		Trade t1 = new Trade("GOOG", 200000, "CANCEL");
		
		Predicate<Trade> p1 = Predicate.isEqual(t1);
		
		for(Trade t : trades){
			if(p1.test(t))
				System.out.println("Matching trade: "+t);
		}
	}

	public static void main(String[] args) {
		Trade trade = new Trade("GOOG", 2_000_000, "NEW");
		ComposingPredicates test = new ComposingPredicates();
		test.testPredicates(trade);
	}
}
