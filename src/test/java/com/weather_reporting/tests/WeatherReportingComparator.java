package com.weather_reporting.tests;

import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.weather_reporting.ui.utils.BaseClass;
import com.weather_reporting.ui.utils.ConfigFileReader;
import com.weather_reporting.webservices.utils.Comparator;
import com.weather_reporting.webservices.weather.WeatherAPI;

public class WeatherReportingComparator extends BaseClass {

	Map<String, String> weatherMap;
	JSONObject weatherResponse_city;

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
		weatherMap = test.currentWeatherReportPage.storeInformationOfWeather();

	}

	/**
	 * Get Current weather data by city name
	 */
	@Test(priority = 3)
	public void verify_Weather_Data_Appears_OnSearching_By_City() {
		weatherResponse_city = WeatherAPI.getWeatherInfo("Noida", ConfigFileReader.getProperty("appid"), 200);

	}

	/**
	 * Get Current weather data by city name And State Code
	 */
	@Test(priority = 4)
	public void verify_Weather_Data_Appears_OnSearching_By_CityAndStateCode() {
		WeatherAPI.getWeatherInfo("London,UK", ConfigFileReader.getProperty("appid"), 200);

	}

	/**
	 * Get Current weather data by city name, State Code, country code
	 */
	@Test(priority = 5)
	public void verify_Weather_Data_Appears_OnSearching_By_City_StateCodeAndCountryCode() {
		WeatherAPI.getWeatherInfo("Noida,UP,IN", ConfigFileReader.getProperty("appid"), 200);

	}

	/**
	 * compare weather temperature from UI and API Return success if temp difference
	 * is less than 2
	 */
	@Test(priority = 6)
	public void compare_Weather_Data() {
		Comparator.userCompareVariation(weatherMap.get("Temperature").toString(),
				weatherResponse_city.getJSONObject("main").get("temp").toString());
	}
}
