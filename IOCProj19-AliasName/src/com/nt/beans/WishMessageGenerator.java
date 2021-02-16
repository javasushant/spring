package com.nt.beans;

import java.util.Date;

public class WishMessageGenerator {
	private Date date;
	static {
		System.out.println("WishMessageGenerator.Static block");
	}
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator.0-param WishMessageGenerator()");
	}
	public void setDate(Date date) {
		System.out.println("WishMessageGenerator.setDate()");
		this.date = date;
	}
	public String generateWishMessage(String user) {
		System.out.println("WishMessageGenerator.generateWishMessage()");
		//get hour of the day
		int hour = date.getHours();
		//geneate wish meassage
		if(hour<12)
			return "Good Morning  " +user;
		else if(hour<16)
			return "Good AfterNoon  " +user;
		else if (hour<20)
			return "Good Evening  " +user;
		else
			return "Good Night  " +user;
		
	}
}
