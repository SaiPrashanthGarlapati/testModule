package com.mommypower.ap.testModule.Util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Repository;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;

@Repository
public class PropertyReader {
	final static Logger logger = Logger.getLogger(PropertyReader.class);

	@BeforeSuite
	public String getProperty(String name) {

		String property = "";
		try {
			Properties prop = new Properties();
			String config = System.getenv("config_path");
			System.out.println("In Property Reader : " + config);
			InputStream input = new FileInputStream(config + "/config.properties");
			prop.load(input);
			property = prop.getProperty(name);
			logger.debug("Requested property for :" + name + " and property is " + property);
		} catch (Exception e) {
			logger.error("Exception Occured" + e.getMessage());
		}
		return property;
	}
}
