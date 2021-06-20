package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.config.BusinessConfig;
import com.nt.config.PresentationConfig;
import com.nt.controller.MainController;

public class NestedIOCContainerTest {
	
	public static void main(String[] args) {
		// create parent IOC container
		AnnotationConfigApplicationContext pCtx = new AnnotationConfigApplicationContext(BusinessConfig.class);
		//create child IOC container
		//get Controller obj
		AnnotationConfigApplicationContext cCtx=new AnnotationConfigApplicationContext(PresentationConfig.class);
		cCtx.setParent(pCtx);
		MainController controller = cCtx.getBean("controller",MainController.class);
		
		//invoke methods
		try {
			controller.showEmployeeDesg("CLERK", "MANAGER", "SALESMAN").forEach(dto->{
				System.out.println(dto);
			});
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}
		cCtx.close();
		pCtx.close();
	}//main
}//class
