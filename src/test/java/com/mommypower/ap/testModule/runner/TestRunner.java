package com.mommypower.ap.testModule.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/resources/feature",glue="com.mommypower.ap.testModule.StepDefination")
public class TestRunner extends AbstractTestNGCucumberTests{

}

