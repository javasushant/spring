package com.nt.service;

import org.springframework.stereotype.Service;

@Service("bank")
public class BamkService {
	public double calSimpleInterest(float pAmt,float rate,float time) {
		System.out.println("BamkService.calSimpleInterest()");
		return (pAmt*rate*time)/100.0f;
	}
	public double calCompoundInterest(float pAmt,float rate,float time) {
		System.out.println("BamkService.calCompoundeInterest()");
		return (pAmt*Math.pow(1+rate/100, time))-pAmt;
	}
}
