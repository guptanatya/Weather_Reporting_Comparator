package com.weather_reporting.ui.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	public static Properties data = new Properties();
	
	public static String getProperty(String property) {
		String value;
		try {
			FileInputStream in = new FileInputStream("src/test/resources/config.properties");
			try {
				data.load(in);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		value = data.getProperty(property);
		return value;
	}
}
