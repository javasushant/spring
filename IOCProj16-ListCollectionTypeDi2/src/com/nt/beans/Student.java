package com.nt.beans;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class Student {
	private List<Integer> marks;
	private List<Date> impDate;
	
	
	public void setMarks(List<Integer> marks) {
		this.marks = marks;
	}
	public void setImpDate(List<Date> impDate) {
		this.impDate = impDate;
	}
	@Override
	public String toString() {
		return "Student [marks=" + marks + ", impDate=" + impDate + "]";
	}
	
	
	
	
	
}
