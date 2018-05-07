package com.mommypower.ap.testModule.StepDefination;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import com.mommypower.ap.testModule.Util.SeleniumDriver;

import cucumber.api.java.en.Given;

@ContextConfiguration(locations = { "classpath:config/spring-test-config.xml" })
public class LoginSteps extends AbstractTestNGSpringContextTests {
	
	@Given("User navigates to login page$")
	public void userNavigatesToLoginPage() {
		System.out.println("Executing the Launching -Started");
		SeleniumDriver.getFirefoxdriver().navigate().to("https://www.mommypower.in");
		
		System.out.println("Executing the Launching -Ended");
	}

}
