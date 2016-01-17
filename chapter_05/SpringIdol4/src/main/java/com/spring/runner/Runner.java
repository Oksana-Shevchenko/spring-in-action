package com.spring.runner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.mind.IMindReader;
import com.spring.mind.IThinker;
import com.spring.performer.IContestant;
import com.spring.performer.IPerformer;


public class Runner {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springIdol.xml");

		//Simple bean with default constructor
		IPerformer performer = (IPerformer)context.getBean("duke");
		performer.perform();
		
		//Introducing new functionality with aspects
		IContestant  performerNewFunctionality = (IContestant)context.getBean("duke");
		performerNewFunctionality.receiveAward();
		
		//Passing parameters to advice
		IThinker thinker = (IThinker) context.getBean("volunteer");
		thinker.thinkOfSomething("la la la");
		IMindReader mindReader = (IMindReader) context.getBean("magician");
		System.out.println(mindReader.getThoughts());
		
		//Passing arguments to annotated advice
		IMindReader mindReaderWithAnnotation = (IMindReader) context.getBean("magicianWithAnnotation");
		System.out.println(mindReaderWithAnnotation.getThoughts());
	}
}
