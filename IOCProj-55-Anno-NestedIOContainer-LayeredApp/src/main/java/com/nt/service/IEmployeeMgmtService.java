package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface IEmployeeMgmtService {
	public List<EmployeeDTO> fetchEmployeeDesg(String desg1,String desg2,String desg3) throws Exception;
}
