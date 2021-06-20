package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

public class MappingSQLOperationsTest {

	public static void main(String[] args) {
		 //create IOC container
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		
		IEmployeeMgmtService service=ctx.getBean("serviceClass",IEmployeeMgmtService.class);
			/*
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
				System.out.println("7499 emp details is :: "+list);
			else
				System.out.println("Employee not found");
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		*/
		try {
			String result= service.updateEmployee("ROCKEY", 7499);
			System.err.println(result);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

}
