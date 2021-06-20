package com.nt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Data
@AllArgsConstructor
public class StudentVO {
//	public StudentVO(String string, String string2, int i, int j) {
//		// TODO Auto-generated constructor stub
	//}
	private String name;
	private String addrs;
	private int sub;
	private int gain;
	
}
