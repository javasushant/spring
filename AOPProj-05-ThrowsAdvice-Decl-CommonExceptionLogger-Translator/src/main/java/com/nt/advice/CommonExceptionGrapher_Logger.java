package com.nt.advice;

import java.io.FileWriter;
import java.io.Writer;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

import com.nt.exception.InternalProblemException;

public class CommonExceptionGrapher_Logger {
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
