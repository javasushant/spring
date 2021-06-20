package com.nt.advice;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformenceMonitpring {
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
