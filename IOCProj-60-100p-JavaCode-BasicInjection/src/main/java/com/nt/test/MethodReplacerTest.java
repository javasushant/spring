package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.beans.WishMessageGenerator;
import com.nt.config.AppConfig;

public class MethodReplacerTest {

	public static void main(String[] args) {
		
		//create IOC container
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		//get Bean Object
//		WishMessageGenerator msg = ctx.getBean("wmg",WishMessageGenerator.class);
//		System.out.println("meassage displayed "+msg.getMessage("Rockey"));
//		((AbstractApplicationContext) ctx).close();
	}

}
