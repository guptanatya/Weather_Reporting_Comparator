package com.weather_reporting.webservices.utils;

import com.weather_reporting.ui.utils.ConfigFileReader;

public class Constants {

	public static final String BASE_URL = ConfigFileReader.getProperty("apiBaseUrl");
	public static final String weatherEndPoint = "/data/2.5/weather";
	
}
