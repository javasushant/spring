package com.nt.test;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.nt.service.EmployeeMgmtServiceImpl;

public class JdbcemplateDirectMethodTest {

	public static void main(String[] args) {
		ApplicationContext ctx= new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get beans class obj
		EmployeeMgmtServiceImpl service=ctx.getBean("service", EmployeeMgmtServiceImpl.class);
		int result=service.listOfEmp();
		System.out.println("TOtal no. :: "+result);
		 System.out.println("=================================");
		 /*
		 System.out.println("Salary of Emp : "+service.fetchEmployeeSalaryByEno(7499));
	
		System.out.println("=================================");
		try {
//		System.out.println("Emp details ::  "+service.fetchEmployeeDetailsByEno(7499));
			Map<String,Object> map=service.fetchEmployeeDetailsByEno(7499);
			map.entrySet().forEach(rows->{
				System.out.println(rows.getKey()+"   "+rows.getValue());
			});
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("=================================");
		try {
//		System.out.println("Emp details by Desg ::  "+service.fetchEmployeeDetailsByDesg("CLERK","SALESMAN", "MANAGER"));
			service.fetchEmployeeDetailsByDesg("CLERK","SALESMAN", "MANAGER").forEach(map->{
				map.entrySet().forEach(row->{
					System.out.println(row.getKey()+"  "+row.getValue());
				});
				System.out.println();
			});
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("=================================");
		try {
		SqlRowSet rowset= service.fetchEmployeeDetailsBySalRange(2000.0f, 5000.0f);
		while(rowset.next()) {
			System.out.println(rowset.getInt(1)+" "+rowset.getString(2)+" "+rowset.getString(3)+" "+rowset.getFloat(4));
		}
		}
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
	
			try {
				System.out.println(service.registerEmployee("Rockey", "Clerk", 1000.0f));
				}
				catch(DataAccessException dae) {
					dae.printStackTrace();
				}
				
			try {
				System.out.println(service.hikeEmployeeSalary(22, 50.0f));
			}
			catch(DataAccessException dae) {
				dae.printStackTrace();
			}*/
			try {
				System.out.println(service.fireEmployeesBySalaryRange(22));
			}
			catch(DataAccessException dae) {
				dae.printStackTrace();
			}
			
		((AbstractApplicationContext) ctx).close();
	}

}
