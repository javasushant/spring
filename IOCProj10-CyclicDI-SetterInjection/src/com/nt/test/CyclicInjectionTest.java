package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.A;

public class CyclicInjectionTest {

	public static void main(String[] args) {
		// create a IOC container obj
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		// create the reader of XmlDefinition 
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		//load Spring bean cfg file
		reader.loadBeanDefinitions("com/nt/cnfs/applicationcontext.xml");
		
		//get the bean obj
		A a = factory.getBean("a1",A.class);
		System.out.println(a);
	}

}
