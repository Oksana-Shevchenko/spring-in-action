package com.spring.runner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.postProcessor.Rabbit;

public class Runner {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("postProcessor.xml");
		Rabbit rabbit = (Rabbit) context.getBean("bugs");
		System.out.println(rabbit.getDescription());
	}
}
