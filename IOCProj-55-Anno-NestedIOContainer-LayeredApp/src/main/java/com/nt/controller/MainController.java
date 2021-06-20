package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.dto.EmployeeDTO;
import com.nt.service.IEmployeeMgmtService;

@Controller("controller")
public class MainController {
	@Autowired
	private IEmployeeMgmtService service;
	
	public List<EmployeeDTO> showEmployeeDesg(String desg1, String desg2, String desg3) throws Exception{
		//use Service class
		List<EmployeeDTO> listDTO = service.fetchEmployeeDesg(desg1, desg2, desg3);
		return listDTO;
	}
}
