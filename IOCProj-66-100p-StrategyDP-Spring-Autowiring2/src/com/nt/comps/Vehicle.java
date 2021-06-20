//Vehicle.java  (Target class
package com.nt.comps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("vehicle")
public class Vehicle {
	@Autowired
	private IEngine engg;
	
	
	
	public void journey(String sourcePlace ,  String destPlace) {
		engg.start();
		System.out.println("journey Started at  :  "+sourcePlace);
		System.out.println("Journey is goinfg on ............");
		engg.stop();
		System.out.println("journey Stoped at  :  "+destPlace);
		
	}
	
}
