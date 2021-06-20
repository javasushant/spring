package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.entity.User;
import com.nt.service.ILoginService;

@Controller
public class LoginController {
	@Autowired
	private ILoginService service;

	@GetMapping("/")
	public String launchWelcomeFile() {
		// return lvn to view Resolver
		return "redirect:login";
	}

	@GetMapping("/login")
	public String showHome(@ModelAttribute("userform") User user) {
		// return lvn
		return "login_form";
	}
		@PostMapping("/login")
		public String processForm(Map<String, Object> map,
		                                                                              @ModelAttribute("userform") User user) {
			//use service
			String result=service.validate(user);
			//keep the result into model attribute
			map.put("resultMsg", result);
			return "login_form";
		}
		
}
