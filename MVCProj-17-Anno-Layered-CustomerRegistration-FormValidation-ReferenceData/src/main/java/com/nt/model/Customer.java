package com.nt.model;

import lombok.Data;

@Data
public class Customer {
	private String Cname;
	private String cadd;
	private Float billAmt;
	private String gender="female";
	private String[] hobbies=new String[] {"Playing games","Cooking"};
	private String country="India";
	private String lang;
}
 