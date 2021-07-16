package com.weather_reporting.ui.tests;

import java.util.Map;

import org.testng.annotations.Test;

import com.weather_reporting.ui.utils.BaseClass;

public class CurrentWeatherReport extends BaseClass {

	@Test(priority = 1)
	public void verifyUserIsOnHomePage() {
		test.homepage.verifyOnHomePage("Local, National, & Global Daily Weather Forecast | AccuWeather");

	}
   /**
    * Store All the weather information of a city 
    */
	@Test(priority = 2)
	public void WeatherReportForParticularCity() {
		test.homepage.searchForLocation("Noida, Uttar Pradesh");
		test.currentWeatherReportPage.verifyCurrentDayAndTime();
		Map weatherMap = test.currentWeatherReportPage.storeInformationOfWeather();
		        
	}
	
	
}
