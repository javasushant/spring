package com.nt.test;

import java.util.Date;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.College;

public class SampleTestDI {

	public static void main(String[] args) {
		//create IOC container
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		// make reader to read this 
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		//load and locate xml file
		reader.loadBeanDefinitions("com/nt/cfgs/applicationcontext.xml");
		
		//get bean class
		College cg= factory.getBean("cg",College.class);
		System.out.println("College various feature : "+cg);
	}
}
