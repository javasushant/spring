package com.nt.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.comps.Vehicle;
import com.nt.config.AppConfig;

public class StrategyDPTest {

	public static void main(String[] args) {
		//create IOC
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//get bean
		Vehicle vehicle = ctx.getBean("vehicle",Vehicle.class);
		vehicle.journey("hyd", "goa");
		ctx.close();
		
	}

}
