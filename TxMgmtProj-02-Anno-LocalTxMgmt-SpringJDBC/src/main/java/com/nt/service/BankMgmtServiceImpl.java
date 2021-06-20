package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.IBankDAO;
@Service("bankService")
public class BankMgmtServiceImpl implements IBankMsmtService {
	@Autowired
	private IBankDAO dao;
	
	
	

	@Override
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = IllegalAccessException.class)
	public String transferMoney(int srcAcno, int destAcno, double amount) throws IllegalAccessException {
		int count1=dao.deposite(destAcno, amount);
		int count2=dao.withdraw(srcAcno, amount);
		if(count1==0 || count2==0) {
//			throw new RuntimeException("Tx rolled back--->Money is not transfered");
			throw new IllegalAccessException("Tx rolled back--->Money is not transfered");
		}
		else
			return "Tx commited --> Money is transfered";
	}

}
