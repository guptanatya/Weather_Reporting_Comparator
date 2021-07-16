package com.weather_reporting.tests;

import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.weather_reporting.ui.utils.BaseClass;
import com.weather_reporting.ui.utils.ConfigFileReader;
import com.weather_reporting.webservices.weather.WeatherAPI;

public class WeatherReportingComparator extends BaseClass {

	@Test(priority = 1)
	public void verifyUserIsOnHomePage() {
		test.homepage.verifyOnHomePage("Local, National, & Global Daily Weather Forecast | AccuWeather");
        test.homepage.clickPopup();
	}

	/**
	 * Store All the weather information of a city
	 */
	@Test(priority = 2)
	public void WeatherReportForParticularCity() {
		test.homepage.searchForLocation("Noida, Uttar Pradesh");
		test.currentWeatherReportPage.verifyCurrentDayAndTime();
		Map weatherMap = test.currentWeatherReportPage.storeInformationOfWeather();
		System.out.println(weatherMap);

	}
	
	/**
	 * Get Current weather data by city name 
	 */
	@Test(priority = 3)
	public void verify_Weather_Data_Appears_OnSearching_By_City() {
		JSONObject weatherResponse_city = WeatherAPI.getWeatherInfo("Noida", ConfigFileReader.getProperty("appid"), 200);
       
	}

	
	/**
	 * Get Current weather data by city name And State Code  
	 */
	@Test(priority = 4)
	public void verify_Weather_Data_Appears_OnSearching_By_CityAndStateCode() {
		JSONObject weatherResponse_cityState = WeatherAPI.getWeatherInfo("London,UK", ConfigFileReader.getProperty("appid"), 200);

	}
 
	/**
	 * Get Current weather data by city name, State Code, country code
	 */
	@Test(priority = 5)
	public void verify_Weather_Data_Appears_OnSearching_By_City_StateCodeAndCountryCode() {
		JSONObject weatherResponse_cityStateCountry = WeatherAPI.getWeatherInfo("Noida,UP,IN", ConfigFileReader.getProperty("appid"), 200);

	}
}
