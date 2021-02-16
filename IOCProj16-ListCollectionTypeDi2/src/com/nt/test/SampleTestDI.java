package com.nt.test;

import java.util.Date;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.CourseInfo;
import com.nt.beans.FacultyInfo;
import com.nt.beans.FruitStore;
import com.nt.beans.Student;

public class SampleTestDI {

	public static void main(String[] args) {
		//create IOC container
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		// make reader to read this 
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		//load and locate xml file
		reader.loadBeanDefinitions("com/nt/cfgs/applicationcontext.xml");
		
		//get bean class
		Student stud= factory.getBean("stud",Student.class);
		System.out.println("College various feature : "+stud);
		System.out.println("\n");
		System.out.println("============================");
		FacultyInfo info = factory.getBean("info",FacultyInfo.class);
		System.out.println("faculty information : "+info);
		System.out.println("\n");
		System.out.println("============================");
		FruitStore finfo= factory.getBean("finfo",FruitStore.class);
		System.out.println("fruit info :  "+finfo);
		System.out.println("\n");
		System.out.println("============================");
		CourseInfo cinfo = factory.getBean("cinfo",CourseInfo.class);
		System.out.println("Course details  : "+cinfo);
	}
}
