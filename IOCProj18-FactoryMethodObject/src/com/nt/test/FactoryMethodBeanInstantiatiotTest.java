package com.nt.test;

import java.util.Calendar;
import java.util.Iterator;
import java.util.Properties;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class FactoryMethodBeanInstantiatiotTest {

	public static void main(String[] args) {
		
		//create IOC container
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		//make readable obj
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		//load and hold cfg file
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		
		//get bean class obj
		Calendar cal = factory.getBean("cal",Calendar.class);
		System.out.println(cal.getClass()+cal.toString());
				
		Class clazz = factory.getBean("clazz",Class.class);
		System.out.println(clazz.getClass()+clazz.toString());
		
		Properties props = factory.getBean("props",Properties.class);
		System.out.println(props.getClass()+props.toString());
		
		System.out.println("=========================================");
		String str1=factory.getBean("s2",String.class);
		System.out.println("str1 obj class "+str1.getClass()+"str1 obj data  "+str1.toString());
		System.out.println("=========================================");
		
		String str2=factory.getBean("s3",String.class);
		System.out.println("str1 obj class "+str2.getClass()+"str1 obj data  "+str2.toString());
		System.out.println("=========================================");
		
		Iterator it=factory.getBean("it",Iterator.class);
		System.out.println("str1 obj class "+it.getClass()+"str1 obj data  "+it.toString());
				
	}

}
