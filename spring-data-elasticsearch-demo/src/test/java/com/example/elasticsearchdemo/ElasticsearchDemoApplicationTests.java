package com.example.elasticsearchdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.elasticsearchdemo.model.Book;
import com.example.elasticsearchdemo.repository.BookRepository;

@SpringBootTest
class ElasticsearchDemoApplicationTests {

	@Autowired
	BookRepository bookRepository;
	
	@Test
	void contextLoads() {
		System.out.println("hello, it runs");
	}
	
	@Test
	void putData() {
		Book book = new Book(2,"manman","fei");
		bookRepository.index(book);
		System.out.println("put done");
	}

	
	@Test
	void findBooks() {
		for (Book book: bookRepository.findByBookNameAndAuthor("manman","man")) {
			System.out.println(book);
		}
		System.out.println(bookRepository.findById(1));
		
	}
	
}
