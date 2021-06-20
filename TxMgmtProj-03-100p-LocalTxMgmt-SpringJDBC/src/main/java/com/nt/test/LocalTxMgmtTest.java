package com.nt.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.BankMgmtServiceImpl;
import com.nt.service.IBankMsmtService;

public class LocalTxMgmtTest {

	public static void main(String[] args) {
		//create IOC container 
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get service class object
		
		IBankMsmtService proxy=ctx.getBean("bankService",IBankMsmtService.class);
		try {
			System.out.println(proxy.transferMoney(1001, 1003, 50000.0));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		//close the container
		ctx.close();
	}
}
