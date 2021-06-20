package com.nt.listener;

import java.util.Date;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class IOCContainerMonitoringListener implements ApplicationListener {
	long start ,end;
	public void onApplicationEvent(ApplicationEvent event) {
		if(event.toString().contains("RefreshedEvent")) {
			System.out.println(new Date());
			start=System.currentTimeMillis();
		}
		else if(event.toString().contains("ClosedEvent")) {
			System.out.println(new Date());
			end=System.currentTimeMillis();
			System.out.println("The Application container is in running mode for :"+(end-start)+" ms");
		}
	}
}
