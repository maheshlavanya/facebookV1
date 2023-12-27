package com.facebookV1.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
	Properties pro;
	
	public Readconfig ()
	{
		File src = new File("./Configurations/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is  " +e.getMessage());
		}		
	}	
	public String getFacebookUrl() {
		String url = pro.getProperty("facebookUrl");
		return url;		
	}
	public String getOrangermUrl() {
		String url = pro.getProperty("orangeUrl");
		return url;	
	}
	public String getUserName() {
		String usrNm = pro.getProperty("userName");
		return usrNm;
	}
	public String getPassword() {
		String pwd = pro.getProperty("password");
		return pwd;
	}
	public String  getChromePath() {
		String chromePath= pro.getProperty("chromepath");
		return chromePath;
	}
	public String  getEdgePath() {
		String edgePath = pro.getProperty("edgepath");
		return edgePath;
	}
	public String getExpectedText() {
		String expText= pro.getProperty("expectedText");
		return expText;
	}
	
}
