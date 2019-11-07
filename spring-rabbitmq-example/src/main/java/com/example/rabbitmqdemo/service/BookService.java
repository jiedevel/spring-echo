package com.example.rabbitmqdemo.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.rabbitmqdemo.model.Book;

@Service
public class BookService {
	
	@RabbitListener(queues = "test-news")
	public void receiveBook(Book book) {
		
		System.out.println("received a new book");
		System.out.println(book.getBookName());
		System.out.println(book.getBookAuthor());
	}
	
	@RabbitListener(queues = "test-emps")
	public void receiveMessage(Message message) {
		System.out.println("test-emps received a new message");
		System.out.println(message.getBody());
		System.out.println(message.getMessageProperties());
	}
}
