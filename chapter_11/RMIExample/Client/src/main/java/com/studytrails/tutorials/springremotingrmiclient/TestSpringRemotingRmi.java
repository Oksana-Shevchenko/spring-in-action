package com.studytrails.tutorials.springremotingrmiclient;

import com.studytrails.tutorials.springremotingrmiserver.GreetingService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringRemotingRmi {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-client.xml");
        GreetingService greetingService = (GreetingService)context.getBean("greetingService");
        String greetingMessage = greetingService.getGreeting("Alpha");
        System.out.println("The greeting message is : " + greetingMessage);
    }
}
