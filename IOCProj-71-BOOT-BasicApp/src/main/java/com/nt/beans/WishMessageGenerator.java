package com.nt.beans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {
	@Autowired
	private LocalDateTime sysDAteTime;
	
	public String generateWishMessage(String msg) {
		int hour=sysDAteTime.getHour()+1;
		if(hour<12)
			return "Good Morning "+msg;
		else if(hour<16)
			return "Good AfterNoon "+msg;
		else if(hour<20)
			return "Good Evening "+msg;
		else
			return "Good Night "+msg;
	}
}
