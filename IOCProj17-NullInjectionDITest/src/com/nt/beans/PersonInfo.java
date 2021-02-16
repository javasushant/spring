package com.nt.beans;

import java.util.Date;

public class PersonInfo {
	private String pname;
	private String paddrs;
	private Date dob;
	private Date doj;
	private Date dom;
	
	
	public PersonInfo(String pname, String paddrs, Date dob, Date doj, Date dom) {
		System.out.println("PersonInfo.5-param-constructor");
		this.pname = pname;
		this.paddrs = paddrs;
		this.dob = dob;
		this.doj = doj;
		this.dom = dom;
	}


	@Override
	public String toString() {
		return "PersonInfo [pname=" + pname + ", paddrs=" + paddrs + ", dob=" + dob + ", doj=" + doj + ", dom=" + dom
				+ "]";
	}
	
	
}