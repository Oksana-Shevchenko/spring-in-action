package com.spring.runner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.knight.IKnight;
import com.spring.quest.impl.QuestException;

public class Runner {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("knights.xml");
		IKnight knight = (IKnight) context.getBean("knight");
		try {
			knight.embarkOnQuest();
		} catch (QuestException e) {
			e.printStackTrace();
		}
	}
}
