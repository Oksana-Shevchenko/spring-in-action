package com.spring.mind.impl;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.spring.mind.IMindReader;
@Aspect
public class MagicianWithAnnotation implements IMindReader {
	private String thoughts;
	
	@Pointcut("execution(* com.spring.mind.IThinker.thinkOfSomething(String)) && args(thoughts)")
	public void thinking(String thoughts){}
	
	@Before("thinking(thoughts)")
	public void interceptThoughts(String thoughts) {
		System.out.println("Intercepting volunteer's thoughts");
		this.thoughts = thoughts;
	}

	public String getThoughts() {
		return thoughts;
	}
}