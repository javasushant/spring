package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;


@Component("emp")
@Data
public class Employee {
	@Value("${per.no}")
	private int no;
	@Value("${per.name}")
	private String name;
}
