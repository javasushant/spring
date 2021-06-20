package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.beans.Employee;

@SpringBootApplication
public class IocProj74BootPropertiesFileYmlApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(IocProj74BootPropertiesFileYmlApplication.class, args);
		//get bean
		Employee emp=ctx.getBean("emp",Employee.class);
		System.out.println("emp details : "+emp);
	}

}
