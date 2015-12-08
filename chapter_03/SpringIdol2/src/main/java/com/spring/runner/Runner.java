package com.spring.runner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.performer.IPerformer;

public class Runner {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springIdol.xml");

		//Abstract component
		IPerformer performerAbstractKenny = (IPerformer)context.getBean("kenny");
		performerAbstractKenny.perform();
		IPerformer performerAbstractDavid = (IPerformer)context.getBean("david");
		performerAbstractDavid.perform();
		
		//Abstract component - overriding method
		IPerformer performerAbstractFrank = (IPerformer)context.getBean("frank");
		performerAbstractFrank.perform();
		
		//General abstract properties
		IPerformer performerAbstractPropertiesTaylor = (IPerformer)context.getBean("taylor");
		performerAbstractPropertiesTaylor.perform();
		IPerformer performerAbstractPropertiesStevie = (IPerformer)context.getBean("stevie");
		performerAbstractPropertiesStevie.perform();
		
		//Replace method
		IPerformer performerReplaceMethod = (IPerformer)context.getBean("harry");
		performerReplaceMethod.perform();
	}
}
