package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.service.IEmployeeService;

@SpringBootApplication
public class SpringJdbc04BootJdbcTemplateCsllBackMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=
				SpringApplication.run(SpringJdbc04BootJdbcTemplateCsllBackMethodsApplication.class, args);
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
//							System.out.println("7499 Emp details are ::"+service.fetchEmployeeByDesg("CLERK", "MANAGER", "SALESMAN"));
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
