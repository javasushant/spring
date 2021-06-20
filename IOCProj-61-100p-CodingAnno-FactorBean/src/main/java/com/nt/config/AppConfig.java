package com.nt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.nt.beans")
@PropertySource(value="com/nt/commons/info.properties")
public class AppConfig {
	public AppConfig() {
		System.out.println("AppConfig.0-param-contructor");
	}
}
