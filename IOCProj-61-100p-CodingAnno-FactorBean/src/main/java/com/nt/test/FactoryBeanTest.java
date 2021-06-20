package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.beans.Customer;
import com.nt.config.AppConfig;

public class FactoryBeanTest {

	public static void main(String[] args) {
		//creates IOC Container
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
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
