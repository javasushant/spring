package com.nt.service;

public interface IBankMsmtService {
	public String transferMoney(int srcAcno,int destAcno,double amount)  throws IllegalAccessException ;
}
