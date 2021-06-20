package com.nt;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.controller.CollegeController;
import com.nt.vo.StudentVO;

@SpringBootApplication
public class IocProj76BootLayredAppCustomerProfielsProperteisFileApplication {
	@Autowired
	private Environment env;
	@Bean(name="c3p0")
	@Profile("uat")
	public DataSource createC3P0() throws Exception{
		System.out.println("IocProj76BootLayredAppCustomerProfielsProperteisFileApplication.createC3P0()");
		ComboPooledDataSource ds= new ComboPooledDataSource();
		ds.setDataSourceName(env.getProperty("spring.datasource.driver-class-name"));
		ds.setJdbcUrl(env.getProperty("spring.datasource.url"));
		ds.setUser(env.getProperty("spring.datasource.username"));
		ds.setPassword(env.getProperty("spring.datasource.password"));
		return ds;
	}
	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(IocProj76BootLayredAppCustomerProfielsProperteisFileApplication.class, args);
		try {
			CollegeController controller=ctx.getBean("controller",CollegeController.class);
			StudentVO vo=new StudentVO("Vicky","Namapur",6500,200000);
			//invoke methods
			String result = controller.details(vo);
			System.out.println("details are : "+result);
		}//try
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("active profile is ::"+Arrays.toString(ctx.getEnvironment().getActiveProfiles()));
	}

}
