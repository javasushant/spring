package com.nt.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nt.model.Customer;

@Controller
public class ShowController {
	
	@GetMapping("/welcome")
	public String showForm(@ModelAttribute("cust") Customer cust) {
		return "customer_form";
	}
	
	
}
