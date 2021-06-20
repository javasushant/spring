package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.controller.BankController;
import com.nt.vo.CustomerVO;

@SpringBootApplication
@ImportResource("com/nt/cfgs/applicationContext.xml")
public class IocProj72BootLayeredAppApplication {

	public static void main(String[] args) {
		//create IOC Container
		
		ApplicationContext ctx= SpringApplication.run(IocProj72BootLayeredAppApplication.class, args);
		
		try{BankController controller=ctx.getBean("controller",BankController.class);
		CustomerVO custVO=new CustomerVO("raja","hyd","100000","2","12");
		//invoke methods
		String result = controller.processCustomer(custVO);
		System.out.println("Interest amout : "+result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		((ConfigurableApplicationContext) ctx).close();
	}

}
