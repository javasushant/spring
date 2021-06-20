package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.exception.InternalProblemException;
import com.nt.service.ShoppingStore;

public class ThrowsAdviceTest {

	public static void main(String[] args) {
		//IOC container 
		ClassPathXmlApplicationContext ctx= new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get proxy class object
		ShoppingStore proxy=ctx.getBean("store",ShoppingStore.class);
		try {
			System.out.println("BillAmount :: "+proxy.calcBillAmount(4000, 2));
		}
		catch(InternalProblemException iae) { // we can do this only when taraget method throws   uncheckceptions
			iae.printStackTrace();
		}
		System.out.println("=============================");
		
		try {
			System.out.println("BillAmount :: "+proxy.calcBillAmount(4000, 0));
		}
		catch(InternalProblemException iae) { // we can do this only when taraget method throws   uncheckceptions
			iae.printStackTrace();
		}
		//close container
		ctx.close();
	}

}
