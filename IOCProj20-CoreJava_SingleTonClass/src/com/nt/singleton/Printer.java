package com.nt.singleton;

public class Printer {
	private static Printer INSTANCE;
	private Printer() {
		System.out.println("Printer.0-param-constructor");
	}
	//factory method
	public static Printer getInstance() {
		if(INSTANCE==null)
			INSTANCE=new Printer();
		return INSTANCE;
	}//factory method
	
	//b.logic
	public void printData(String msg) {
		System.out.println(msg);
	}

}//class
