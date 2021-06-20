package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
public class PersistantConfig {
	@Bean("hkds")
	public HikariDataSource createDatatSource() {
		HikariDataSource ds= new  HikariDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:SYS");
		ds.setUsername("system");
		ds.setPassword("manager");
		ds.setMaximumPoolSize(10);
		ds.setMinimumIdle(100);
		ds.setIdleTimeout(300);
		ds.setMaxLifetime(50000);
		return ds;
	}
}
