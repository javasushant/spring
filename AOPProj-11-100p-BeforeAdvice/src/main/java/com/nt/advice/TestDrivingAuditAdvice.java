package com.nt.advice;

import java.io.FileWriter;
import java.io.Writer;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Component("tdAuditAdvice")
@Aspect

public class TestDrivingAuditAdvice {
	/*	public void testDriving(JoinPoint jp) throws Throwable{
			System.out.println("TestDrivingAuditAdvice.testDriving()");
			Object args[] =jp.getArgs();
			String auditLogMsg=args[0]+" customer has come for testing driving of "+args[1]+" model car on  "+new Date();
			Writer writer =new FileWriter("E:\\testdrive_audit.txt",true);
			writer.write(auditLogMsg+"\n");
			writer.flush();
			writer.close();
		}*/
		@Before(value = "execution (java.lang.String com.nt.service.CarShowRoom.sellCar(..)) and args(custName,carModel,price)")
		public void testDriving(String custName,String carModel,double price) throws Throwable{
			System.out.println("TestDrivingAuditAdvice.testDriving()");
			String auditLogMsg=custName+" customer has come for testing driving of "+ carModel+"model car on  "+new Date();
			Writer writer =new FileWriter("E:\\testdrive_audit.txt",true);
			writer.write(auditLogMsg+"\n");
			writer.flush();
			writer.close();
		}
}
