package com.nt.beans;

public class BankLoanInterestCalculator {
	public float calculateInterestAmount(float pAmt,float rate,float time) {
		//b.logic for interest
		return (float) ((pAmt*Math.pow((1+(rate/100)),time))-pAmt);
	}
}
