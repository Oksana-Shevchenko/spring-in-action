package com.spring.runner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.performer.IPerformer;
import com.spring.performer.impl.InstrumentalistNonSpringComponent;

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
		
		//Replace method (Lookup method)
		IPerformer performerLookupMethod = (IPerformer)context.getBean("stevieWithLookupMethod");
		performerLookupMethod.perform();

		//Run with -javaagent:C:\Users\Orange\.m2\repository\org\aspectj\aspectjweaver\1.6.1\aspectjweaver-1.6.1.jar
		/*IPerformer instrumentalistNonSpringComponent = new InstrumentalistNonSpringComponent();
		instrumentalistNonSpringComponent.perform();
		*/
	}
}
