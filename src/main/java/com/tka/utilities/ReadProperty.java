package com.tka.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperty {

	public static String readConfig(String key) {
		
		FileInputStream fis=null;
		Properties prop = null;
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/Config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return prop.getProperty(key);
	}
}
