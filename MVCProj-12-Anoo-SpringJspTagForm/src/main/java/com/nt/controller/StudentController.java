package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Student;

@Controller
public class StudentController {
	@GetMapping("/welcome")
	public String showHome( @ModelAttribute("stud") Student st) {
		st.setName("MoM");
		return "home";
	}
		@PostMapping("/welcome")
		public String registerStudent(Map<String, Object> map, @ModelAttribute("stud") Student st) {
		System.out.println("Data save is :: "+st);
		//create object for model 
		map.put("stude", st);
		return "result";
	}
}
