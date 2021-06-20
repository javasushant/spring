package com.nt.advice;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("pmAdvice")
@Aspect
@Order(2)
public class PerformenceMonitpring {
	
	@Around(value =" execution(double com.nt.service.BamkService.cal*(..))")
	
	public Object performence(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("PerformenceMonitpring.performence() before entering ..");
		long start =System.currentTimeMillis();
		Object retVal=pjp.proceed(); //cal Target method
		long end =System.currentTimeMillis();
		System.out.println("PerformenceMonitpring.performence() After exiting ..");
		System.out.println(pjp.getSignature()+" with args "+Arrays.toString(pjp.getArgs())+" has taken "+(end-start)+ " ms to complete");
		return retVal;
		
	}
}
