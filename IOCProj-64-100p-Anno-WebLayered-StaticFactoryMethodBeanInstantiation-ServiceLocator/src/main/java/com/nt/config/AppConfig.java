package com.nt.config;

import java.util.Calendar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.nt.external.IICCScoreComp;
import com.nt.locator.ICCScoreCompServiceLocator;

@Configuration
@ComponentScan(basePackages = "com.nt")
public class AppConfig {
	
	@Bean(name="extComp")
	public IICCScoreComp createExternalComp() throws Exception {
		return ICCScoreCompServiceLocator.getExternalServiceComp();
	}
	@Bean(name = "cal")
	public Calendar createCalender() {
		return Calendar.getInstance();
	}
}
