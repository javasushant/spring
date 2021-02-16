package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.singleton.Printer;
import com.nt.singleton.Summ;

public class SingleTonTest {

	public static void main(String[] args) {
		//create IOC Containe
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		//make reader component
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		// load the cfg file
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		
		//get spring bean class for defult singleton
		System.out.println("default singleton");
		Printer pr1 = factory.getBean("p1",Printer.class);
		System.out.println(pr1.hashCode());		
		Printer pr2 = factory.getBean("p1",Printer.class);
		System.out.println(pr2.hashCode());	
		System.out.println(pr1==pr2);
		
		//for singleton  java class with scope= singleton
		System.out.println("scope  singleton");
		Printer pr3 = factory.getBean("p2",Printer.class);
		System.out.println(pr3.hashCode());		
		Printer pr4 = factory.getBean("p2",Printer.class);
		System.out.println(pr4.hashCode());	
		System.out.println(pr3==pr4);
		
		//for singleton  java class with scope singleton and factoey method
		System.out.println("scope  singleton and factory method");
		Printer pr5 = factory.getBean("p3",Printer.class);
		System.out.println(pr5.hashCode());		
		Printer pr6 = factory.getBean("p3",Printer.class);
		System.out.println(pr6.hashCode());	
		System.out.println(pr5==pr6);
		
		//for singleton  java class with scope prototype
		System.out.println("scope  prototype");
		Printer prs1 = factory.getBean("p4",Printer.class);
		System.out.println(prs1.hashCode());		
		Printer prs2 = factory.getBean("p4",Printer.class);
		System.out.println(prs2.hashCode());	
		System.out.println(prs1==prs2);
		
		//for singleton  java class with scopeprototype and factoey method
		System.out.println("scope prototype  and factory method");
		Printer prs3 = factory.getBean("p5",Printer.class);
		System.out.println(prs3.hashCode());		
		Printer prs4 = factory.getBean("p5",Printer.class);
		System.out.println(prs4.hashCode());	
		System.out.println(prs3==prs4);
		
		//create object for Singleton class
	/*	Printer p1=Printer.getInstance();
		Printer p2=Printer.getInstance();
		System.out.println(p1.hashCode()+" "+p2.hashCode());
		
		System.out.println("==============================");
		Summ s1= Summ.getInstance();
		Summ s2= Summ.getInstance();
		float result=s1.CircleArea(6);
		float result2=s1.CircleArea(6);
		System.out.println(result);
		System.out.println(result2);*/
	}


}

