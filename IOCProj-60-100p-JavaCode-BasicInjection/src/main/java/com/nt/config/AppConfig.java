package com.nt.config;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.nt.beans")
public class AppConfig {
	static {
		System.out.println("AppConfig.static block()");
	}
	public AppConfig() {
		System.out.println("AppConfig.0-param-constructor");
	}
	@Bean(value = "dt")
	public LocalDateTime createDate() {
		System.out.println("AppConfig.createDate()");
		return LocalDateTime.now();
	}
}
