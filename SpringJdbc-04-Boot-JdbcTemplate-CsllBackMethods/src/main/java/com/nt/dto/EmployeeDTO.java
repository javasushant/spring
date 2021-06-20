package com.nt.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
	private int empNo;
	  private String ename;
	  private String job;
	  private float sal;
}
