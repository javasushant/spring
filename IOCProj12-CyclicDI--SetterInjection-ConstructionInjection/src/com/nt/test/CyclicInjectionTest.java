package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.A;
import com.nt.beans.B;

public class CyclicInjectionTest {

	public static void main(String[] args) {
		// create IOC container
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		//create reader obj
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		// load spring bean class
		
		reader.loadBeanDefinitions("com/nt/cnfs/applicationcontext.xml");
		
		// get bean obj
		A a = factory.getBean("a1",A.class);
		System.out.println(a);
		
//		B b = factory.getBean("b1",B.class);
//		System.out.println(b);
	}
}
