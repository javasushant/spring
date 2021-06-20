package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.nt.bo.StudentBO;
import com.nt.dao.IStudentDAO;
import com.nt.dto.StudentDTO;
@Service("custService")

public class StudentServiceImple implements IStudentService {
	@Autowired
	private IStudentDAO dao;
	
 public StudentServiceImple() {
		System.out.println("StudentServiceImple.StudentServiceImple()");
	}
	

	@Override
	public String execute(StudentDTO dto) throws Exception {
		Float total=(float) (dto.getGain()/dto.getSub());
		String result=null;
		if(total<40.0f) {
			result="Third class";
		}
		else if(total<55.0f) {
			result="Second class";
		}
		else {
			result="First class";
		}
			
		//create BO class
		StudentBO bo=new StudentBO();
		bo.setName(dto.getName());
		bo.setAddrs(dto.getAddrs());
		bo.setGain(dto.getGain());
		bo.setTotal(total);
		bo.setResult(result);
		
		//use dao class
		int count =dao.insert(bo);
		
		return (count==0)?"Result is not updated in DB s/w":"Result is updated and details are as follows"+total+"  "+result;
		
		
		
	}

}
