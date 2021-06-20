package com.nt.test;

import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.config.AppConfig;

public class I188NApp {

	public static void main(String[] args) {
		//create IOC container
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext(AppConfig.class);
		//create Locale object
			Locale locale=new Locale(args[0],args[1]);
			//get Messages..
			String msg1=ctx.getMessage("wishMsg", new Object[] {"buddy"," welcome"}, "msg", locale);
			String msg2=ctx.getMessage("welcome.msg", new Object[] {}, "msg2", locale);
			String msg3=ctx.getMessage("bye.msg", new Object[] {}, "msg3", locale);
			
			System.out.println(msg1+"    "+msg2+"   "+msg3);
			
			//close container
			ctx.close();
	}

}
