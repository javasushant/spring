package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.service.IEmployeeService;

public class CallBackMethodTest {

	public static void main(String[] args) {
		//create IOC container
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get service class obj
		IEmployeeService service=ctx.getBean("empService",IEmployeeService.class);
		//invoke method
				try {
					System.out.println("7499 Emp details are ::"+service.fetchEmployeeByNo(7499));
				}
				catch(DataAccessException dae) {
					dae.printStackTrace();
				}
				try {
//					System.out.println("7499 Emp details are ::"+service.fetchEmployeeByDesg("CLERK", "MANAGER", "SALESMAN"));
					service.fetchEmployeeByDesg("CLERK", "MANAGER", "SALESMAN").forEach(row->{
						System.out.println(row+" ");
					});
					System.out.println();
				}
				catch(DataAccessException dae) {
					dae.printStackTrace();
				}
				//close container
				((AbstractApplicationContext) ctx).close();
	}

}
