package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.model.Customer;
@Repository("custdao")
public class CustomerDAOImpl implements ICustomerDAO {
	private static final String CUSTOMER_QUERY="INSERT INTO CUSTOMER_LAYERED VALUES(CUSTNO_SEQ.NEXTVAL,?,?,?)";
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public int insert(Customer cust) {
		int count =jt.update(CUSTOMER_QUERY, cust.getCname(),cust.getCadd(),cust.getBillAmt());
		return count;
	}

}
