package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.TestBeans;

public class PropertyEditorsTest {

	public static void main(String[] args) {
		//create IOC CONTAINER
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//get bean
		TestBeans tb=ctx.getBean("pinfo",TestBeans.class);
		System.out.println(tb+" \n");
		((AbstractApplicationContext) ctx).close();
	}

}
