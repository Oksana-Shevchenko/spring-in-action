package com.spring.audience;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AudienceAdviceAroundWithAnnotation {
	@Pointcut("execution(* com.spring.performer.IPerformer.perform(..))")
	public void performance() {
		
	}
	@Around("performance()")
	public void watchPerformance(ProceedingJoinPoint joinPoint) {
		try {
			System.out.println("The audience is taking their seats.");
			System.out.println("The audience is turning off their cellphones.");
			long start = System.currentTimeMillis();
			joinPoint.proceed();
			long end = System.currentTimeMillis();
			System.out.println("CLAP CLAP CLAP CLAP CLAP");
			System.out.println("The performance took "+(end-start)+" milliseconds");
		} catch (Throwable e) {
			System.out.println("Boo! We want our moneyt back");
		}		
	}
}
