package com.nt.comps;

import org.springframework.stereotype.Component;

@Component("pEngine")
public class PetrolEngine implements IEngine {
	@Override
	public void start() {
		System.out.println("PetrolEngine.start():: Petrol engine started");
	}

	@Override
	public void stop() {
		System.out.println("PetrolEngine.stop():: Petrol engine stoped");
	}
}
