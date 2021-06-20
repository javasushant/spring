package com.nt.locator;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import com.nt.external.ICCScoreCompImpl;
import com.nt.external.IICCScoreComp;

public class ICCScoreCompServiceLocator {

	
	public static IICCScoreComp getExternalServiceComp() throws Exception {
		System.out.println("ICCScoreCompServiceLocator.getObject()");
		//Actually we should use JNDI code getting external comp ref. since we take external component as normal
		//java class for simplification , so we are going to create object for that class directly
		IICCScoreComp comp = new ICCScoreCompImpl();
		return comp;
	}

}
