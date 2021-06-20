package com.nt.advice;

import java.io.FileWriter;
import java.io.Writer;

import org.aspectj.lang.JoinPoint;

public class DiscountCouponAdvice {
	/*public void discount(JoinPoint jp,double billAmt) throws Throwable{
		System.out.println("DiscountCouponAdvice.discount()");
		Object args[]=jp.getArgs();
		String offer=null;
		if(billAmt<25000)
			offer="10% discount is allowed";
		else if(billAmt<50000)
			offer="20% discount is allowed";
		else if(billAmt<100000)
			offer="30% discount is allowed";
		else
			offer="50% discount is allowed";
		String	billDiscription ="Customer has purchased these items like -->  "+args[1]+" with total amount of  "+args[1]+"  he will get discount of "+offer;
		Writer writer= new FileWriter("E:\\coupon.txt");
		writer.write(billDiscription);
		writer.flush();
		writer.close();
	}*/
	
	
	public void discount(String[] items,double[] price,double billAmt) throws Throwable{
		System.out.println("DiscountCouponAdvice.discount()");
		String offer=null;
		if(billAmt<25000)
			offer="10% discount is allowed";
		else if(billAmt<50000)
			offer="20% discount is allowed";
		else if(billAmt<100000)
			offer="30% discount is allowed";
		else
			offer="50% discount is allowed";
		String	billDiscription ="Customer has purchased these items like -->  "+items.toString()+" with total amount of  "+price.toString()+"  he will get discount of "+offer;
		Writer writer= new FileWriter("E:\\coupon.txt");
		writer.write(billDiscription);
		writer.flush();
		writer.close();
		
	}
}
