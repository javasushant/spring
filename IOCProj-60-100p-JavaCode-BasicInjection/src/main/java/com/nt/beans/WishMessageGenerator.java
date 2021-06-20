package com.nt.beans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("wmg")
@Lazy(value = true)
public class WishMessageGenerator {
	@Autowired
	private LocalDateTime date;
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator.0-param-constructor");
	}
	public String getMessage(String user) {
		int hours = 0;
		System.out.println("WishMessageGenerator.getMessage()");
		hours= date.getHour();
		if(hours<12)
			return "Good Morning "+user;
		else if(hours<16)
			return "Good AfterNoon "+user;
		else if(hours<19)
			return "Good Evening "+user;
		else
			return "Good Night "+user;
	}
}
