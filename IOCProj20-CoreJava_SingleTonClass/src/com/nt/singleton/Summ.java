package com.nt.singleton;

public class Summ {
	private static Summ INSTANCE;
	private final float PI=3.14f;
	
	private Summ() {
		System.out.println("Summ.0-param-constructor()");
	}
	//factory method
	public static Summ getInstance() {
		if(INSTANCE==null)
			INSTANCE= new Summ();
		return INSTANCE;
	}
	
	//b.logic
	public float CircleArea(float radius) {
		return PI*radius*radius;
	}
}
