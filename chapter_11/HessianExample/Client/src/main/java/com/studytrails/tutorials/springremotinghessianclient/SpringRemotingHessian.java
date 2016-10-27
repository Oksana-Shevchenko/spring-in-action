package com.studytrails.tutorials.springremotinghessianclient;

import com.studytrails.tutorials.springremotinghessianserver.GreetingService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringRemotingHessian {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-client.xml");
        GreetingService greetingService = (GreetingService)context.getBean("greetingService");
        String greetingMessage = greetingService.getGreeting("Alpha");
        System.out.println("The greeting message is:" +greetingMessage);
    }
}
