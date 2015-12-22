package com.spring.runner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.performer.IPerformer;

public class Runner {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springIdol.xml");

		//Autowiring by name (instrument)
		IPerformer performerAutowiringByName = (IPerformer)context.getBean("kennyAutowiringByName");
		performerAutowiringByName.perform();
		
		//Autowiring by type (IInstrument)
		IPerformer performerAutowiringByType = (IPerformer)context.getBean("kennyAutowiringByType");
		performerAutowiringByType.perform();
		
		//Autowiring Constructor (IPoem)
		IPerformer performerAutowiringConstructor = (IPerformer)context.getBean("dukeAutowiringConstructor");
		performerAutowiringConstructor.perform();
		
		//Autowiring default
		IPerformer performerAutowiringDefault = (IPerformer)context.getBean("dukeAutowiringDefault");
		performerAutowiringDefault.perform();
		
		//Autowiring with annotation @Autowired
		IPerformer performerWithAutowiredAnnotation = (IPerformer)context.getBean("instrumentalistWithAutowiredAnnotation");
		performerWithAutowiredAnnotation.perform();
		
		// Autowiring with annotation @Autowired and custom @Qualifier
		IPerformer performerWithAutowiredAndCustQualifierAnnotation = (IPerformer)context.getBean("instrumentalistWithAutowiredAndCustQualifierAnnotation");
		performerWithAutowiredAndCustQualifierAnnotation.perform();
		
		//Autowiring with annotation @Inject
		IPerformer performerInjectAnnotation = (IPerformer)context.getBean("knifeJuggler");
		performerInjectAnnotation.perform();
		
		//Autowiring with annotation @Inject and @Named
		IPerformer performerWithInjectAndNamedAnnotation = (IPerformer)context.getBean("instrumentalistWithInjectAndNamedAnnotation");
		performerWithInjectAndNamedAnnotation.perform();
		
		//Autowiring automatically - component scan
		IPerformer performerComponentScan = (IPerformer)context.getBean("eddie");
		performerComponentScan.perform();
	}
}
