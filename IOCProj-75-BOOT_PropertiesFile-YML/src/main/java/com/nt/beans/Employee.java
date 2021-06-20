package com.nt.beans;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


import lombok.Data;


@Component("emp")
@Data
@ConfigurationProperties(prefix = "per.info")
public class Employee {
	private int no;
	private String name;
	//LIST/SET PROPERTIES
	private List<String> nickName;
	private List<Long> phoneNumber;
	private Set<String> sweets;
	//Map properties
	private Map<String, Long> idCards;
	//private Properties favFruits;
	
	//Has-A property
	//private Address addrs;
}
