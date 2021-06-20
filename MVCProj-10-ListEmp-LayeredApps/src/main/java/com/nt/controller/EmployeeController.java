package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.dto.EmployeeDTO;
import com.nt.service.IEmployeeMgmtService;
@Controller
public class EmployeeController {
	@Autowired
	private IEmployeeMgmtService service;
	
	//@RequestMapping("/welcome")
	@GetMapping("/welcome")
	public String showHome() {
		return "home";
	}
	//@RequestMapping("/show")
	@GetMapping("/show")
	public String collectAllEmployee(Map<String, Object> map) {
		//use service
		List<EmployeeDTO> listDTO =service.fetchAllEmp();
		//keep result in Model Attributes
		map.put("listDTO", listDTO);
		return "show_emp";
	}
}
