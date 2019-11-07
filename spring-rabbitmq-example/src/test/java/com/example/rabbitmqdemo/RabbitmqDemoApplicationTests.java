package com.example.rabbitmqdemo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.rabbitmqdemo.model.Book;

@SpringBootTest
class RabbitmqDemoApplicationTests {
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@Autowired
	AmqpAdmin amqpAdmin;

	@Test
	void contextLoads() {
	
		
	}
	
	@Test
	public void directSend()  {
		System.out.println(" direct test send");
		Map<String, Object> map = new HashMap();
		map.put("msg","first test msg");
		map.put("data", Arrays.asList("hello",12346,true));
		rabbitTemplate.convertAndSend("spring-test-direct","test-emps",map);
		
	}
	
	@Test
	public void receive() {
		Object receivedOb =rabbitTemplate.receiveAndConvert("test-news");
		System.out.println(receivedOb.getClass());
		System.out.println(receivedOb);
	}
	
	@Test
	public void broadcast() {
		System.out.println("fanout test send");
		Map<String, Object> map = new HashMap();
		map.put("msg","first test msg");
		map.put("data", Arrays.asList("hello",12346,true));
		rabbitTemplate.convertAndSend("spring-test-fanout" , "22",map);
	}

	
	
	@Test 
	public void createExchange() {
		System.out.println("create an exchange by amqp");
		amqpAdmin.declareExchange(new  DirectExchange("create-exchange"));
	}
	
	@Test 
	public void createQueue() {
		System.out.println("create a queue by amqp");
		amqpAdmin.declareQueue(new Queue("create-queue",true));
	}
	
	@Test
	public void createBinding() {
		System.out.println("create a binding by amqp");
		amqpAdmin.declareBinding(new Binding("create-queue",Binding.DestinationType.QUEUE,"create-exchange","create-queue",null));
		
	}
	
	
	
}
