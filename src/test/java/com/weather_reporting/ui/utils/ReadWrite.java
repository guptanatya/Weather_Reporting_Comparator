package com.weather_reporting.ui.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadWrite {

	
public static Properties data = new Properties();
static String path ="src/test/resources/testData.properties";
	
	public static String getProperty(String property) {
		String value;
		try {
			FileInputStream in = new FileInputStream(path);
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
	
	public static String setProperty(String property,String value) {
		
		try {
			FileInputStream in = new FileInputStream(path);
			try {
				data.load(in);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return (String) data.setProperty(property, value);
		 
	}
}
