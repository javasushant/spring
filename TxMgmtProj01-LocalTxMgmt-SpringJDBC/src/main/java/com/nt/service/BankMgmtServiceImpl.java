package com.nt.service;

import com.nt.dao.IBankDAO;

public class BankMgmtServiceImpl implements IBankMsmtService {
	private IBankDAO dao;
	
	
	public BankMgmtServiceImpl(IBankDAO dao) throws IllegalAccessException {
		this.dao = dao;
	}

	@Override
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
