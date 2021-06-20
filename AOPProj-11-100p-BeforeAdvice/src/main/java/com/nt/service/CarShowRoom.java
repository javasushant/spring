package com.nt.service;

import org.springframework.stereotype.Service;

@Service("showroom")
public class CarShowRoom {
	public String sellCar(String custName,String carModel,double price) {
		System.out.println("CarShowRoom.sellCar()");
		if(carModel.equalsIgnoreCase("civic")) {
			return "car "+carModel +" is sold out at price :: "+price+ " to customer  ::  "+ custName;
		}
		else {
			return "Car " +carModel  +" is not availabe  for sale ";
		}
	}
}
