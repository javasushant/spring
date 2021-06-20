package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@SpringBootApplication
public class SpringJdbc10BootMappingSqlOperationAsSubClassApplication {

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(SpringJdbc10BootMappingSqlOperationAsSubClassApplication.class, args);
		IEmployeeMgmtService service=ctx.getBean("serviceClass",IEmployeeMgmtService.class);
		
	try {
		Employee emp=service.fetchPoliticalPartyDetailsByPartyId(7499);
		if(emp!=null)
			System.out.println("7499 emp details is :: "+emp);
		else
			System.out.println("Employee not found");
	} catch (DataAccessException e) {
		e.printStackTrace();
	}
	
	try {
		List<Employee> list=service.fetchPoliticalPartiesByPartyNames("CLERK", "MANAGER", "SALESMAN");
		if(list!=null)
			list.forEach(det->{
				System.out.println(det);
			});
		else
			System.out.println("Employee not found");
	} catch (DataAccessException e) {
		e.printStackTrace();
	}
	/*
	try {
		String result= service.updateEmployee("ROCKEY", 7499);
		System.err.println(result);
	} catch (DataAccessException e) {
		e.printStackTrace();
	}
	*/
	}

}
