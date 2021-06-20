package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.Customer;

public class FactoryBeanTest {

	public static void main(String[] args) {
		//creates IOC Container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		///get Bean Class Object
		Customer cust = ctx.getBean("cust",Customer.class);
		System.out.println("------------------------------");
		//show details
		cust.showProductDetails();
		System.out.println("--------------------------------");
		//close customer
		((AbstractApplicationContext) ctx).close();
	}

}
