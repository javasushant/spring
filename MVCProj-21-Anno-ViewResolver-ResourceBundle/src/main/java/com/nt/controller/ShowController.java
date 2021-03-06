package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShowController {
	@RequestMapping("/welcome")
	public String showHome() {
		return "home";
	}
	/*
	@GetMapping("/input")
	public String SaveData(@RequestParam("sno") int no,
			               @RequestParam("sname") String name, 
			               Map<String, Object> map) {
		//make model class object
		map.put("sno", no);
		map.put("sname", name);
		return "result";
	}
	*/
	/*
	@GetMapping("/input")
	public String SaveData(@RequestParam int no,
			               @RequestParam String name, 
			               Map<String, Object> map) {
		//make model class object
		map.put("sno", no);
		map.put("sname", name);
		return "result";
	}
	*/
	
	@RequestMapping("/input")
	public String SaveData(@RequestParam(required = false,defaultValue ="101") int no,
			               @RequestParam(required = false,defaultValue =" Annonymus Student") String name, 
			               Map<String, Object> map) {
		//make model class object
		map.put("sno", no);
		map.put("sname", name);
		return "result";
	}
}
