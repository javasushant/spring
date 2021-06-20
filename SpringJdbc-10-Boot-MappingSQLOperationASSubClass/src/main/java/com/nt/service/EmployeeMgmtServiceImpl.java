package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

@Service("serviceClass")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeDAO dao;
	@Override
	public Employee fetchPoliticalPartyDetailsByPartyId(int eno) {
		
	Employee emp=dao.getPoliticalPartyDetailsByPartyId(eno);
		return emp;
	}

	@Override
	public List<Employee> fetchPoliticalPartiesByPartyNames(String job1, String job2, String job3) {
		List<Employee>  list=dao.getPoliticalPartiesByPartyNames(job1, job2, job3);
		return list;
	}

	@Override
	public String updateEmployee(String ename, int empno) {
		int result=dao.updateEmployee(ename, empno);
		return (result==0)?"Result is not updated":"Result is saved";
	}

}
