package com.example.elasticsearchdemo.repository;

import java.util.List;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.example.elasticsearchdemo.model.Book;

public interface BookRepository extends ElasticsearchRepository<Book, Integer> {
	
	public List<Book> findByBookName(String bookName);
	
	
	public List<Book> findByBookNameAndAuthor(String bookName, String author);
}
