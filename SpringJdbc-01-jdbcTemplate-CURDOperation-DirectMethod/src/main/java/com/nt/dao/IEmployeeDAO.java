package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public interface IEmployeeDAO {
	
	public int fetchAllEmployee();
	public Float getEmployeeSalaryByEno(int eno);
	public Map<String, Object> getEmployeeDetailsByEno(int eno);
	public List<Map<String, Object>> getEmployeeDetailsByDesg(String desg1,String desg2,String desg3);
	public SqlRowSet getEmployeeDetailsbySalaryRange(float startSalary,float endSalary);
	 public  int  insertEmployee(String ename,String desg,float salary);
	 public  int  updateEmployeeSalary(int eno,float newSalary);
	 public   int  deleteEmployeeBySalaryRange(int eno);
}
