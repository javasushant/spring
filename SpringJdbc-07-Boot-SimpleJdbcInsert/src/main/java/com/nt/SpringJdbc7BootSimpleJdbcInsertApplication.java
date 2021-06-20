package com.nt;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.nt.model.ActorDetails;
import com.nt.service.IActorMgmtService;

@SpringBootApplication
public class SpringJdbc7BootSimpleJdbcInsertApplication {
	@Autowired
	private DataSource ds;
	
	@Bean(name="sji")
	public SimpleJdbcInsert createdata() {
		return new SimpleJdbcInsert(ds);
	}
	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(SpringJdbc7BootSimpleJdbcInsertApplication.class, args);
		//get bean
				IActorMgmtService service =ctx.getBean("actorService",IActorMgmtService.class);
				try {
					System.out.println(service.registerActor(new ActorDetails(425,"Sushant","mumbai",55544555L,5642.0)));
					} catch (DataAccessException e) {
					e.printStackTrace();
				}
				((AbstractApplicationContext) ctx).close();
	}

}
