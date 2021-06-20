package com.nt.test;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.controller.CollegeController;
import com.nt.vo.StudentVO;

public class RealTimeDPTestOfApp {

	public static void main(String[] args) {
		//create IOC Container
		ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
		
		CollegeController controller=ctx.getBean("controller",CollegeController.class);
		
		// take input from enduser 
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Student Name :  ");
		String name=sc.next();
		System.out.println("Enter Student Address :  ");
		String addrs=sc.next();
		System.out.println("Enter no. of subject : ");
		int sub=sc.nextInt();
		System.out.println("Enter Total gain marks in Exam : ");
		int gain=sc.nextInt();
		
		
		//use VO class
		StudentVO vo= new StudentVO();
		vo.setName(name);
		vo.setAddrs(addrs);
		vo.setSub(sub);
		vo.setGain(gain);
		
		//use controller class
		try {
			String resultOfStudent=controller.details(vo);
			System.out.println(resultOfStudent);
		}
		catch(Exception e) {
			System.out.println("Problem in Customer Registration");
			e.printStackTrace();
		}
	}

}
