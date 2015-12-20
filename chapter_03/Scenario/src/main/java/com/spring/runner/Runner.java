package com.spring.runner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.Coconut;

public class Runner {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("scenario.xml");
		
		Coconut coconutRuby = (Coconut) context.getBean("coconutRuby");
		coconutRuby.drinkThemBothUp();
		
		Coconut coconutBsh = (Coconut) context.getBean("coconutBsh");
		coconutBsh.drinkThemBothUp();
		
		/*
		Coconut coconutGroovy = (Coconut) context.getBean("coconutGroovy");
		coconutGroovy.drinkThemBothUp();
		*/
		
		Coconut coconutBshInternal = (Coconut) context.getBean("coconutBshInternal");
		coconutBshInternal.drinkThemBothUp();
	}
}
