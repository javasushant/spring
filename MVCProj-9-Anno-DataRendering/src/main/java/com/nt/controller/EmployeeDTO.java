package com.nt.controller;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
	private String addrs;
	private String home;
	
	public EmployeeDTO(String addrs, String home) {
		super();
		this.addrs = addrs;
		this.home = home;
	}
	
	
	
}
