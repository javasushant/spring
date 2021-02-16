package com.nt.beans;

import java.util.Date;
import java.util.Set;

public class FacultyInfo {
	private Set <Long>phoneNumbers;
	private Set<Date> impDates;
	/**
	 * @param phoneNumbers
	 * @param impDates
	 */
	public FacultyInfo(Set<Long> phoneNumbers, Set<Date> impDates) {
		this.phoneNumbers = phoneNumbers;
		this.impDates = impDates;
	}
	@Override
	public String toString() {
		return "FacultyInfo [phoneNumbers=" + phoneNumbers + ", impDates=" + impDates + "]";
	}
	
	
}
