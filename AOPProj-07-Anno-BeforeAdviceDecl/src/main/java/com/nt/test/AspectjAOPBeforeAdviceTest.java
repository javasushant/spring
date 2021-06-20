package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.CarShowRoom;

public class AspectjAOPBeforeAdviceTest {

	public static void main(String[] args) {
		//get IOC CONTAINER
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get proxy class object
		CarShowRoom proxy = ctx.getBean("showroom",CarShowRoom.class);
		//invoke method
//		try {
//			System.out.println(proxy.sellCar("Shubham ", "Huindai Venue ", 90000.0));
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
		System.out.println("==================================================");
		//invoke method
		try {
			System.out.println(proxy.sellCar("Atul ", "civic ", 250000.0));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		((AbstractApplicationContext) ctx).close();
	}
}
