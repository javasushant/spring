package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.dto.StudentDTO;
import com.nt.service.IStudentService;
import com.nt.vo.StudentVO;
@Controller("controller" )
public class CollegeController {
	@Autowired
	private IStudentService service;

	
	
	public String details(StudentVO vo) throws Exception{
		//create dto class 
		StudentDTO dto = new StudentDTO();
		dto.setName(vo.getName());
		dto.setAddrs(vo.getAddrs());
		dto.setSub(vo.getSub());
		dto.setGain(vo.getGain());
		
		System.out.println(vo.getName()+"  "+vo.getAddrs());
		System.out.println(dto.getName()+"  "+dto.getAddrs());
		//use Service class
		String output= service.execute(dto);
		
		
		return output;
		
	}
}
