package com.nt.service;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.support.rowset.SqlRowSet;

//import com.nt.dao.EmployeeDAOImpl;
import com.nt.dao.IEmployeeDAO;

public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {
	
	private IEmployeeDAO dao;
	public EmployeeMgmtServiceImpl( IEmployeeDAO dao) {
		this.dao=dao;
	}
	@Override
	public int listOfEmp() {
		int count=dao.fetchAllEmployee();
		return count;
	}
	@Override
	public Float fetchEmployeeSalaryByEno(int eno) {
		float salary=dao.getEmployeeSalaryByEno(eno);
		return salary;
	}
	@Override
	public Map<String, Object> fetchEmployeeDetailsByEno(int eno) {
		Map<String, Object> map=dao.getEmployeeDetailsByEno(eno);
		return map;
	}
	@Override
	public List<Map<String, Object>> fetchEmployeeDetailsByDesg(String desg1, String desg2, String desg3) {
		List<Map<String, Object>> map=dao.getEmployeeDetailsByDesg(desg1, desg2, desg3);
		return map;
	}
	@Override
	public SqlRowSet fetchEmployeeDetailsBySalRange(float startSalary, float endSalary) {
		SqlRowSet rowset =dao.getEmployeeDetailsbySalaryRange(startSalary, endSalary);
		return rowset;
	}
	@Override
	public String registerEmployee(String name, String desg, float salary) {
		int result=dao.insertEmployee(name, desg, salary);
		
		return (result==0)?"Registration Failed":"Registration is Succesfull";
	}
	@Override
	public String hikeEmployeeSalary(int eno, float percentage) {
		//get current salary of employee
		float salary= fetchEmployeeSalaryByEno(eno);
		//calculate new salary
		float newsalary=salary+(salary*percentage/100.0f);
		//use dao
		int count=dao.updateEmployeeSalary(eno, newsalary);
		
		return count==1? "Employee Salary updated with ::"+newsalary:"Employee salary not updated";
	}
	@Override
	public String fireEmployeesBySalaryRange(int eno) {
		int count =dao.deleteEmployeeBySalaryRange(eno);
		return count==0?"No employees found for deletion":count+"no.of employees are found and deleted";
	}

}
