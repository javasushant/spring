package com.nt.test;

import java.util.Date;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.SampleBean;

public class SampleTestDI {

	public static void main(String[] args) {
		//create IOC container
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		// make reader to read this 
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		//load and locate xml file
		reader.loadBeanDefinitions("com/nt/cfgs/applicationcontext.xml");
		
		//get bean class
		SampleBean bean1 =factory.getBean("com.nt.beans.SampleBean",SampleBean.class);
		System.out.println("bean id of bean1 :: "+bean1+" "+bean1.getClass());
		
		SampleBean bean2 =factory.getBean("com.nt.beans.SampleBean",SampleBean.class);
		System.out.println("bean id of bean1 :: "+bean2+" "+bean2.getClass());
		SampleBean bean3 =factory.getBean("com.nt.beans.SampleBean",SampleBean.class);
		System.out.println("bean id of bean1 :: "+bean3+" "+bean3.getClass());
		
		Date date = factory.getBean("date",java.util.Date.class);
		System.out.println(date);
	}

}
