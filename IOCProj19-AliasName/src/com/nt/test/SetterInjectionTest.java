package com.nt.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.nt.beans.WishMessageGenerator;

public class SetterInjectionTest {

	public static void main(String[] args) {
		//hold and locate the spring bean file
		FileSystemResource res = new FileSystemResource("src/com/nt/cfgs/applicationContext.xml");
		// crrate IOC container 
		XmlBeanFactory factory = new XmlBeanFactory(res);
		//get target Spring bean class object from factoryObject
		WishMessageGenerator generator = (WishMessageGenerator) factory.getBean("wishMessageGenerator");
		WishMessageGenerator generator2 = (WishMessageGenerator) factory.getBean("wmsg1");
		WishMessageGenerator generator3 = (WishMessageGenerator) factory.getBean("wmsg2");
		System.out.println(generator2.hashCode()+"  "+generator3.hashCode()+"  "+generator.hashCode());
		WishMessageGenerator generator4 = (WishMessageGenerator) factory.getBean("don1");
		WishMessageGenerator generator5 = (WishMessageGenerator) factory.getBean("don2");
		WishMessageGenerator generator6 = (WishMessageGenerator) factory.getBean("don3");
		WishMessageGenerator generator7 = (WishMessageGenerator) factory.getBean("don4");
		System.out.println(generator4.hashCode()+"  "+generator5.hashCode()+"  "+generator6.hashCode()+"  "+generator7.hashCode());
		//invoke the b.logic
		System.out.println("result "+ generator.generateWishMessage("Sushant"));
	}//main
}//class
