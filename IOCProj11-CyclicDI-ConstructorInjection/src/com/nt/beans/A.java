package com.nt.beans;

public class A {
	private B b;

	/**
	 * @param b
	 */
	public A(B b) {
		System.out.println("A.1-param-constuctor");
		this.b = b;
	}

	@Override
	public String toString() {
		return "A [b=]";
	}
	
}
