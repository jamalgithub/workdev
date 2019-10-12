package com.madhusudhan.j8.streams.commonops;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.madhusudhan.j8.domain.Movie;
import com.madhusudhan.j8.domain.Trade;
import com.madhusudhan.j8.util.MovieUtil;
import com.madhusudhan.j8.util.TradeUtil;

// Collecting operations
public class Collecting {
	List<Trade> trades = TradeUtil.createTrades();

	private void collectIntoAList() {
		List<Trade> tradeCollection = trades.stream().collect(Collectors.toList());

		System.out.println(tradeCollection);
	}
	
	private static void collectIntoAList2() {
		String frenchCounting = "un:deux:trois:quatre";
        List<String> gmailList = Pattern.compile(":")
                .splitAsStream(frenchCounting)
                .collect(Collectors.toList());
        gmailList.forEach(System.out::println);
	}

	private void collectIntoASet() {
		Set<Trade> tradeCollection = trades.stream().collect(Collectors.toSet());

		System.out.println(tradeCollection);
	}
	
	private static void collectIntoASet2() {
		String []roseQuote = "a rose is a rose is a rose".split(" ");
        Set<String> words = Arrays.stream(roseQuote).collect(Collectors.toSet());
        words.forEach(System.out::println);
	}
	
	private static void collectIntoATreeSet() {
		String []roseQuote = "a rose is a rose is a rose".split(" ");
        Set<String> words = Arrays.stream(roseQuote).collect(Collectors.toCollection(TreeSet::new));
        words.forEach(System.out::println);
	}

	private void collectIntoToAMap() {
		List<Movie> movies = MovieUtil.createMovies();

		Map<String, Movie> movieMap = movies.stream().collect(Collectors.toMap(Movie::getName, movie -> movie));
		System.out.println(movieMap);
	}
	
	private static void collectIntoToAMap2() {
		 Map<String, Integer> nameLength = Stream.of("Arnold", "Alois", "Schwarzenegger")
	                .collect(Collectors.toMap(Function.identity(), name -> name.length()));
	     nameLength.forEach((name, len) -> System.out.printf("%s - %d \n", name, len));
	}

	public static void main(String[] args) {
		new Collecting().collectIntoAList();
		Collecting.collectIntoAList2();
		new Collecting().collectIntoASet();
		Collecting.collectIntoASet2();
		Collecting.collectIntoATreeSet();
		new Collecting().collectIntoToAMap();
		Collecting.collectIntoToAMap2();
	}

}
