package com.spring.runner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.auditorium.impl.Auditorium;
import com.spring.performer.IPerformer;
import com.spring.stage.impl.Stage;
import com.spring.ticket.impl.Ticket;

public class Runner {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springIdol.xml");
		
		//Simple bean with default constructor
		IPerformer performer = (IPerformer)context.getBean("duke");
		performer.perform();
		
		//Simple bean with constructor
		IPerformer performerWithConstructor = (IPerformer)context.getBean("dukeWithConstructor");
		performerWithConstructor.perform();
		
		//Simple bean - inject object ref with constructor
		IPerformer performerInjectObjectIntoConstructor = (IPerformer)context.getBean("dukeInjectObjectIntoConstructor");
		performerInjectObjectIntoConstructor.perform();
		
		//Creating simple bean throw factory method
		Stage stageWithFactoryMethod = (Stage)context.getBean("stage");
		stageWithFactoryMethod.getInstance();
		
		//Creating simple bean with prototype scope 
		Ticket ticketBeanWithPrototypeScope = (Ticket)context.getBean("ticket");

		//Initializing and destroying beans
		Auditorium auditoriumWithMethodsInitAndDestroy = (Auditorium)context.getBean("auditorium");
		
		//Simple bean - inject  value into bean properties
		IPerformer performerInjectSimplValueIntoProp = (IPerformer)context.getBean("kenny");
		performerInjectSimplValueIntoProp.perform();
	}
}
