package com.madhusudhan.j8.streams.primitivestreams;

import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

import com.madhusudhan.j8.domain.Trade;
import com.madhusudhan.j8.util.TradeUtil;

public class PrimitiveStreams {

	List<Trade> trades = TradeUtil.createTrades();

	private void tradeQuantity() {
		Optional<Integer> quantity = trades.stream().map(Trade::getQuantity).reduce(Integer::sum);
		System.out.println(quantity.orElse(-1));
	}

	private void intStream() {
		int[] ints = new int[] { 2, 4, 6, 8, 10 };

		IntStream intStream = IntStream.of(ints);
		intStream.forEach(System.out::println);

		IntStream intStream2 = IntStream.of(1, 2, 3, 5);
		intStream2.forEach(System.out::println);
	}

	private void doubleStream() {
		double[] doubles = new double[] { 2, 4, 6, 8, 10 };

		DoubleStream doubleStream = DoubleStream.of(doubles);
		doubleStream.forEach(System.out::println);

		DoubleStream doubleStream2 = DoubleStream.of(10.2, 2.4, 33.8, 55.1);
		doubleStream2.forEach(System.out::println);
	}

	private void convertStream() {
		int sumQuantity = trades.stream().mapToInt(Trade::getQuantity).sum();
		System.out.println(sumQuantity);
	}

	public static void main(String[] args) {
		new PrimitiveStreams().tradeQuantity();
		new PrimitiveStreams().intStream();
		new PrimitiveStreams().doubleStream();
		new PrimitiveStreams().convertStream();
	}

}
