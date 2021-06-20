package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/welcomes")
	public String showHome() {
		return "homePageDef";
	}
	@GetMapping("/java")
	public String showJavaCourses() {
		return "javaPageDef";
	}
	@GetMapping("/oracle")
	public String showOracleCourses() {
		return "javaPageDef";
	}
	@GetMapping("/dotnet")
	public String showDotNetCourses() {
		return "javaPageDef";
	}
	@GetMapping("/news")
	public String showNewsCourses() {
		return "news";
	}
}
