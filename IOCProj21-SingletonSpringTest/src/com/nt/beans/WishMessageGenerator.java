package com.nt.beans;

public class WishMessageGenerator {
	
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator.WishMessageGenerator(0-param Constructor");
	}
	public String sayHello(String msg) {
		return "GOOD MORNING  " +msg;
	}
	@Override
	public String toString() {
		return "WishMessageGenerator []";
	}
	
}
