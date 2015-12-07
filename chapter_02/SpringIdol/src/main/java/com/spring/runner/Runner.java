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

		//Simple bean - inject inner beans
		IPerformer performerInjectInnerBean = (IPerformer)context.getBean("kennyInnerBean");
		performerInjectInnerBean.perform();
		
		//Simple bean - use p namespace
		IPerformer performerUsePNamespace = (IPerformer)context.getBean("kennyWithPNamespace");
		performerUsePNamespace.perform();
		
		//Collections - list
		IPerformer performerListCollections = (IPerformer)context.getBean("hankList");
		performerListCollections.perform();
		
		//Collections - set
		IPerformer performerSetCollections = (IPerformer)context.getBean("hankSet");
		performerSetCollections.perform();
		
		//Collections - map
		IPerformer performerMapCollections = (IPerformer)context.getBean("hankMap");
		performerMapCollections.perform();
		
		//Collections - Properties
		IPerformer performerProperties = (IPerformer)context.getBean("hankProperties");
		performerProperties.perform();

		//SpEl - reference propertie
		IPerformer performerSpElRefProperties = (IPerformer)context.getBean("carl");
		performerSpElRefProperties.perform();
	}
}
