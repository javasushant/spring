package com.nt.beans;

import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import lombok.Data;
@Data
public class TestBeans {
	private String name;
	private float age;
	private int luckyNumber;
	private Date doj;
	private String[] moles;
	private byte[] academicPercentage;
	private long adharNo;
	private char favChar;
	private File fileLocation;
	private Locale favLocaale;
	private URL fbUrl;
	private Class favClass;
	private Properties props;
}
