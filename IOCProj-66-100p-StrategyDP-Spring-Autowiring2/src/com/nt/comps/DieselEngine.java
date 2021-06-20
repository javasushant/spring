package com.nt.comps;

import org.springframework.stereotype.Component;

@Component("engg")
public class DieselEngine implements IEngine {

	@Override
	public void start() {
		System.out.println("DieselEngine.start():: Diesel engine started");
	}

	@Override
	public void stop() {
		System.out.println("DieselEngine.stop():: Diesel engine stoped");
	}

}
