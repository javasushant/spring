package com.nt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	private int empno;
	@NonNull
	private String ename;
	@NonNull
	private String job;
	
	private Float sal;
}
