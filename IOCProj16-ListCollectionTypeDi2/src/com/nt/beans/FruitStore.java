package com.nt.beans;

import java.util.Date;
import java.util.Map;

public class FruitStore {
	private Map<String, Float> fruitInfo;
	private Map<String,Date> impDates;
	/**
	 * @param fruitInfo
	 * @param impDates
	 */
	public FruitStore(Map<String, Float> fruitInfo, Map<String, Date> impDates) {
		this.fruitInfo = fruitInfo;
		this.impDates = impDates;
	}
	@Override
	public String toString() {
		return "FruitStore [fruitInfo=" + fruitInfo + ", impDates=" + impDates + "]";
	}
	
	
}
