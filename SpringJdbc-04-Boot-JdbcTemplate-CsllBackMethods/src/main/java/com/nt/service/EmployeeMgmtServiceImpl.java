package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.IEmployeeDAO;
import com.nt.dto.EmployeeDTO;
@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeDAO dao;
	@Override
	public EmployeeDTO fetchEmployeeByNo(int eno) {
		//use DAO
		EmployeeBO bo=dao.getEmployeeByNo(eno);
		//convert BO to DAO
		EmployeeDTO dto= new EmployeeDTO();
		BeanUtils.copyProperties(bo, dto);
		return dto;
	}
	@Override
	public List<EmployeeDTO> fetchEmployeeByDesg(String desg1, String desg2, String desg3) {
		// use DAO
		List<EmployeeBO> listbo=dao.getEmployeesByDesgs(desg1, desg2, desg3);
		//save all data from Bo to DTO
		List<EmployeeDTO> listdto=new ArrayList();
		listbo.forEach(bo->{
			EmployeeDTO dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo, dto);
			listdto.add(dto);
			
		});
		return listdto;
	}//fetchEmployeesByDesg
}//class
