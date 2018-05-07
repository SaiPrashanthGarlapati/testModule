package com.mommypower.ap.testModule.Util;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;

@Service
public class SeleniumDriver {
	final static Logger logger = Logger.getLogger(SeleniumDriver.class);
	
	@Autowired
	private static PropertyReader propertyReader;

	// private static final String geckoPath = "";
	private static WebDriver driver;
	private static WebDriverWait wait;

	@BeforeSuite
	public static WebDriver getFirefoxdriver() {
		if (driver != null) {
			return driver;
		} else {
			logger.info("Initializing the Web Driver");
			System.out.println("Starting Firefox browser");
			if(propertyReader == null){
				System.out.println("propertyReader is null");
				//return driver;
			}
			final String geckoPath = propertyReader.getProperty("geckopath");
			System.setProperty("webdriver.gecko.driver", geckoPath + "geckodriver.exe");
			driver = new FirefoxDriver();
			return driver;
		}
	}

	public static WebDriverWait getWebDriverWait() {
		if (wait != null) {
			return wait;
		} else {
			wait = new WebDriverWait(getFirefoxdriver(), 100);
			return wait;
		}
	}

}
