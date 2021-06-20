package com.nt.comps;

import org.springframework.stereotype.Component;

@Component("cngEngine")
public class CNGEngine implements IEngine {
	@Override
	public void start() {
		System.out.println("CNGEngine.start():: CNG engine started");
	}

	@Override
	public void stop() {
		System.out.println("CNGEngine.stop():: CNG engine stoped");
	}
}
