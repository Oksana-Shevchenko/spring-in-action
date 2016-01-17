package com.spring.audience;

import org.aspectj.lang.ProceedingJoinPoint;

public class AudienceAdviceAround {
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
