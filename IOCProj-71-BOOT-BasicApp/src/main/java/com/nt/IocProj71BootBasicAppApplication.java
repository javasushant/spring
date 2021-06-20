package com.nt;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.beans.WishMessageGenerator;

@SpringBootApplication
public class IocProj71BootBasicAppApplication {
	@Bean(name="dt")
	public LocalDateTime createLocalDateTime() {
		return LocalDateTime.now();
	}
	
	public static void main(String[] args) {
		//create IOC container
		ApplicationContext ctx= SpringApplication.run(IocProj71BootBasicAppApplication.class, args);
		//get Target class Obj
		WishMessageGenerator generator=ctx.getBean("wmg",WishMessageGenerator.class);
		System.out.println(generator.generateWishMessage("Sushant "));
		((ConfigurableApplicationContext) ctx).close();
	}
}
