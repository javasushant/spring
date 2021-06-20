package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Customer;
import com.nt.service.ICustomerMgmtService;

@Controller
public class ShowController {
	@Autowired
	private ICustomerMgmtService service;
	
	@GetMapping("/welcome")
	public String showForm(@ModelAttribute("cust") Customer cust) {
		cust.setCadd("SPJ");
		return "home";
	}
	
	@PostMapping("/welcome")
	public String show(Map<String, Object> map , 
			                                     @ModelAttribute("cust") Customer cust) {
		//use service class
		System.out.println(cust);
		String resultMsg=service.logic(cust);
		map.put("resultMsg", resultMsg);
		return "result";
		
	}
}
