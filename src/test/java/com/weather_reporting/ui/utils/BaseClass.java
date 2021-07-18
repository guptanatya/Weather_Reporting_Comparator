package com.weather_reporting.ui.utils;

import java.lang.reflect.Method;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.weather_reporting.ui.initiator.TestSession;

public class BaseClass {

	public TestSession test;

	@BeforeClass
	public void launchAccuWeatherApplication() {

		test = new TestSession(this.getClass().getSimpleName());
		test.launchApplication(ConfigFileReader.getProperty("baseurl"));

	}

	@BeforeMethod
	public void testMethodName(Method method) {
		System.out.println("\n" + "TEST STEP: " + method.getName());
	}

	@BeforeSuite
	@Parameters(value = { "email", "service" })
	public void setupMail(@Optional("guptanatya9@gmail.com") String email, @Optional("AccWeather") String service) {
		System.setProperty("email", email);
		System.setProperty("service", service);
	}

	@AfterClass
	public void Close_Test_Session() {
		test.closeBrowserSession();
	}

}
