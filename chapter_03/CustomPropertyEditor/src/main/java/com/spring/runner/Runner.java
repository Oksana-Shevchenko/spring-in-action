package com.spring.runner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.contact.Contact;

public class Runner {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("customPropEditor.xml");
		Contact contact = (Contact) context.getBean("contact");
		System.out.println(contact.getPhoneNumber());
	}
}
