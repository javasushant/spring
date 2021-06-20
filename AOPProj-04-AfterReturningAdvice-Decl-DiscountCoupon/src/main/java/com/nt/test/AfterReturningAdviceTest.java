package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.OnlineStore;

public class AfterReturningAdviceTest {

	public static void main(String[] args) {
		//create IOC container
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get bean of spring bean
		OnlineStore proxy=ctx.getBean("oStore",OnlineStore.class);
		//invoke method
		try {
			System.out.println("Purchase details "+proxy.coupon(new String[] {"PHONE","TV","REFRIGERATOR"}, new double[] {5000,3000,65000}));
		} catch (Exception e) {
			e.printStackTrace();
		}
		ctx.close();
	}

}
