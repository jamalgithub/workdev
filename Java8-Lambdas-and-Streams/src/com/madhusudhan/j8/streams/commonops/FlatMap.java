package com.madhusudhan.j8.streams.commonops;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import com.madhusudhan.j8.domain.Actor;
import com.madhusudhan.j8.domain.Movie;
import com.madhusudhan.j8.util.MovieUtil;

// FlatMap functionality
public class FlatMap {
	
	List<Movie> movies = MovieUtil.createMoviesAndActors();
	String[] fruits = new String[]{"apples","oranges"};
	String[] veggies = new String[]{"beans","peas"};
	
	private void flatMapMovies(){
		Stream<Actor> actorsStream = movies.stream().flatMap(m -> m.getActors().stream());
		
		actorsStream.forEach(System.out::println);
	}
	
	private void flatMapFruiteAndVeggies() {
		Stream<List<String>> fruitsAndVeggies = Stream.of(Arrays.asList(fruits), Arrays.asList(veggies));
		
		fruitsAndVeggies.flatMap(s -> s.stream())
			.sorted()
			.forEach(System.out::println);
	}
	
	public static void uniqueCharacters() {
		 String []string= "you never know what you have until you clean your room".split(" ");
	     Arrays.stream(string)
            .flatMap(word -> Arrays.stream(word.split("")))
            //.sorted()
            .distinct()
            .forEach(System.out::print);
	}
	
	public static void main(String[] args) {
		new FlatMap().flatMapFruiteAndVeggies();
		new FlatMap().flatMapMovies();
		FlatMap.uniqueCharacters();
	}

}
