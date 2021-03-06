package com.jamal.springboot.springbootin10steps.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jamal.springboot.springbootin10steps.domain.Book;

@RestController
public class BooksController {
	
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return Arrays.asList(
				new Book(1l, "Mastering Spring 5.2", "Ranga Karanam"),
				new Book(2l, "Mastering Spring MVC 5.2", "Ranga Karanam"),
				new Book(2l, "Mastering Spring Security", "Ranga Karanam")
				);
	}
}