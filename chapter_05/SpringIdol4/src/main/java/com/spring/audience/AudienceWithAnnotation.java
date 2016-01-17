package com.spring.audience;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AudienceWithAnnotation {
	@Pointcut("execution(* com.spring.performer.IPerformer.perform(..))")
	public void performance() {
		
	}
	@Before("performance()")
	public void takeSeat() {
		System.out.println("Annotation: The audience is taking their seats");
	}
	@Before("performance()")
	public void turnOffCellPhones() {
		System.out.println("Annotation: The audience turning off thier cellphones");
	}
	@AfterReturning("performance()")
	public void applaud() {
		System.out.println("Annotation: CLAP CLAP CLAP CLAP CLAP CLAP");
	}
	@AfterThrowing("performance()")
	public void demandRefund() {
		System.out.println("Annotation: Boo! We want our money back");
	}
}
