package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.model.ActorDetails;
import com.nt.service.IActorMgmtService;

public class SimpleJdbcInsertTest {

	public static void main(String[] args) {
		//create IOC CONTAINER
		ApplicationContext ctx= new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get bean
		IActorMgmtService service =ctx.getBean("actorService",IActorMgmtService.class);
		try {
			System.out.println(service.registerActor(new ActorDetails(420,"Sushant","mumbai",55544555L,5642.0)));
			} catch (DataAccessException e) {
			e.printStackTrace();
		}
		((AbstractApplicationContext) ctx).close();
	}

}
