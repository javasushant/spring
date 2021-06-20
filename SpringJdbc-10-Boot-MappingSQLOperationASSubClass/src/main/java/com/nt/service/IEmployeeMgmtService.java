package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {
	public  Employee  fetchPoliticalPartyDetailsByPartyId(int eno);
    public List<Employee> fetchPoliticalPartiesByPartyNames(String job1,String job2,String job3);
    public String updateEmployee(String ename,int empno);
}
