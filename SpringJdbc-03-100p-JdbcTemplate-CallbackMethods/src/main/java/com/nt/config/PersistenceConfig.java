package com.nt.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration 
@ComponentScan(basePackages = "com.nt.dao")
public class PersistenceConfig {
		
		@Bean(name = "hkds")
		public DataSource createDatasource() {
			HikariDataSource hkds=new HikariDataSource();
			hkds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			hkds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:SYS");
			hkds.setUsername("system");
			hkds.setPassword("manager");
			hkds.setMaximumPoolSize(100);
			hkds.setIdleTimeout(50);
			return hkds;
		}//hkds
		
		@Bean(name = "jt")
		public JdbcTemplate createJt() {
			return new JdbcTemplate(createDatasource());
		}
}
