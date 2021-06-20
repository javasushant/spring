package com.nt.service;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public interface IEmployeeMgmtService {
	public int listOfEmp();
	public Float fetchEmployeeSalaryByEno(int eno);
	public Map<String, Object> fetchEmployeeDetailsByEno(int eno);
	public List<Map<String, Object>> fetchEmployeeDetailsByDesg(String desg1,String desg2,String desg3);
	public SqlRowSet fetchEmployeeDetailsBySalRange(float startSalary,float endSalary);
	 public  String registerEmployee(String name, String desg, float salary);
	  public   String  hikeEmployeeSalary(int eno,float percentage);
	  public    String fireEmployeesBySalaryRange(int eno);
}
