package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.ICustomerDAO;
import com.nt.model.Customer;
@Service("custserive")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService {
	@Autowired
	private ICustomerDAO dao;
	@Override
	public String logic(Customer cust) {
		int result=dao.insert(cust);
		return (result==0)?"Record is not submitted":"submitted result is stored DB s/w";
		
	}

}
