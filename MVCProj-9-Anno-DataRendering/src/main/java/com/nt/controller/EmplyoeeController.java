package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmplyoeeController {
	
	@RequestMapping("/welcome")
	public String listData(Map<String, Object> map) {
		//create Model Data
		map.put("name", "Raja");
		map.put("age", "28");
		List<String> l=List.of("Suresh","Mahesh","Ganesh");
		Set<String> city = Set.of("Mumbai","Delhi","Kolkata");
		Map<String, Object> result = Map.of("Chemistry",78,"Physics",81,"Maths",56);
		String food[] = new String[] {"PAV BHAJI","CHHOLE-BHATURE","RASSOGULLA"};
		map.put("food", food);
		map.put("result", result);
		map.put("l", l);
		map.put("city", city);
		//use DTO class
		EmployeeDTO dto = new EmployeeDTO("Bihar", "SPJ");
		map.put("dtoval", dto);
		return "show";
	}
}
