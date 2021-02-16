package com.nt.beans;

public class B {
	private A a;

	/**
	 * @param b
	 */
	public B(A a) {
		System.out.println("A.1- param constructor");
		this.a = a;
	}

	@Override
	public String toString() {
		return "B [a=]";
	}
	 
	
}
