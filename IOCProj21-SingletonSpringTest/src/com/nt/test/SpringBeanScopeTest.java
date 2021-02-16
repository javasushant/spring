package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.WishMessageGenerator;

public class SpringBeanScopeTest {

	public static void main(String[] args) {
		
		//IOC container
		DefaultListableBeanFactory factory= new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		
		//get spring bean class obj
		WishMessageGenerator generator = factory.getBean("wmg1", WishMessageGenerator.class);
		System.out.println(generator+" "+generator.sayHello("BHAI")+" " +generator.hashCode());
		WishMessageGenerator generator3 = factory.getBean("wmg1", WishMessageGenerator.class);
		System.out.println(generator3+" "+generator3.sayHello("BHAI")+" " +generator3.hashCode());
		System.out.println("");
		WishMessageGenerator generator1 = factory.getBean("wmg2", WishMessageGenerator.class);
		System.out.println(generator1+" "+generator1.sayHello("BHAI") +" "+generator1.hashCode());
		WishMessageGenerator generator4 = factory.getBean("wmg2", WishMessageGenerator.class);
		System.out.println(generator4+" "+generator4.sayHello("BHAI") +" "+generator4.hashCode());
	}

}
