package com.nt.service;

public class OnlineStore {
	public double coupon(String[] items,double[] price) {
		System.out.println("DiscountCouponAdvice.coupon()");
		double billAmt=0.0;
		for(double p:price) {
			billAmt=billAmt+p;
		}
		
		
		return billAmt;
	}
}
