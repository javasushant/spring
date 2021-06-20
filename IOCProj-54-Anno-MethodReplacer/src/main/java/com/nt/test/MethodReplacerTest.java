package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.BankLoanInterestCalculator;

public class MethodReplacerTest {

	public static void main(String[] args) {
		
		//create IOC container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//get Bean Object
		BankLoanInterestCalculator calc=ctx.getBean("blic",BankLoanInterestCalculator.class);
		System.out.println(calc.getClass()+"  "+calc.getClass().getSuperclass());
		System.out.println("Interest Amount  ::"+calc.calculateInterestAmount(10000, 5, 12));
		((AbstractApplicationContext) ctx).close();
	}

}
