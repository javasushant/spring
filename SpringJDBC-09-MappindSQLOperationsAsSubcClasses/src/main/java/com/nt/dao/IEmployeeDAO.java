package com.nt.dao;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeDAO {
	 public  Employee  getPoliticalPartyDetailsByPartyId(int eno);
     public List<Employee> getPoliticalPartiesByPartyNames(String job1,String job2,String job3);
     public int updateEmployee(String ename,int empno);
}
	

