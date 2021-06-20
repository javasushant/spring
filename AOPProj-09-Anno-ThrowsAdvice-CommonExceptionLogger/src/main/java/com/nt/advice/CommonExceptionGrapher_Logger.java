package com.nt.advice;

import java.io.FileWriter;
import java.io.Writer;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.nt.exception.InternalProblemException;
@Component("escLogger")
@Aspect
public class CommonExceptionGrapher_Logger {
	
	@AfterThrowing(value="execution(double com.nt.service.ShoppingStore.calcBillAmount(..))",throwing = "iae")
public void exceptionLogger(JoinPoint jp,IllegalArgumentException iae) throws Throwable{
	//common exception loggging
	Writer writer= new FileWriter("F:/expLogger.txt", true);
	writer.write(jp.getSignature()+"  with args  "+Arrays.toString(jp.getArgs())+ " has raiseed exception "+iae+" \n");
	writer.flush();
	writer.close();
	//Exception translator
	throw new InternalProblemException(jp.getSignature()+" with args "+Arrays.toString(jp.getArgs())+ " has raised exception ");
}
}
