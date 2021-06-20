package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.beans.Employee;


@SpringBootApplication
public class IocProj73BootPropertiesFileApplication {

	public static void main(String[] args) {
//		SpringApplication application=new SpringApplication();
//		application.setBannerMode(org.springframework.boot.Banner.Mode.OFF);
		ApplicationContext ctx= SpringApplication.run(IocProj73BootPropertiesFileApplication.class, args);
		Employee emp=ctx.getBean("emp",Employee.class);
		System.out.println(emp);
	}
}
