package com.nt.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.cfgs.AppConfig;
import com.nt.service.BamkService;

public class AspectJAOPAroundAdviceTest {

	public static void main(String[] args) {
		//IOC Container
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		BamkService proxy=ctx.getBean("bank",BamkService.class);
		//invoke method
		System.out.println("Simple interest "+proxy.calSimpleInterest(10000, 5, 12));
		System.out.println("-------------------------------------------------");
		System.out.println("Simple interest "+proxy.calSimpleInterest(10000, 5, 12));
		System.out.println("-------------------------------------------------");
		System.out.println("Compound interest "+proxy.calCompoundInterest(10000, 5, 12));
		System.out.println("-------------------------------------------------");
		System.out.println("Compound interest "+proxy.calCompoundInterest(10000, 5, 12));
		System.out.println("-------------------------------------------------");
		
	ctx.close();
	}

}
