package com.nt.test;


import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.PersonInfo;

public class NullInjectionTest {

	public static void main(String[] args) {
		//create IOC Container
		DefaultListableBeanFactory factory= new DefaultListableBeanFactory();
		// make a reader stream to read factory obj
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		//make availabe applicationContext file for IOC conatainer
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		
		//get Spring bean obj.
		PersonInfo rs = factory.getBean("rs",PersonInfo.class);
		System.out.println(rs);
		PersonInfo rt = factory.getBean("rt",PersonInfo.class);
		System.out.println(rt);
		
		PersonInfo rn = factory.getBean("rn",PersonInfo.class);
		System.out.println(rn);
		
	}

}
