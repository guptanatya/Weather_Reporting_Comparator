package com.weather_reporting.ui.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenShot {

	WebDriver driver;
	
	public TakeScreenShot()
	{
		this.driver = driver;
	}
	
		
	public void takeScreenshot(String methodName)
	{
		Date date = new Date();
		String newDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		
		File newFile = new File(System.getProperty("user.dir")+ File.separator +"/target/ScreenShots"+File.separator+methodName+File.separator+newDate);
		boolean exist = newFile.exists();
		if(!exist) {
			new File(System.getProperty("user.dir")+ File.separator +"/target/ScreenShots"+File.separator+methodName+File.separator+newDate).mkdir();
		}
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
			String targetFile = System.getProperty("user.dir")+ File.separator +"/target/ScreenShots"+File.separator+methodName+File.separator+newDate+File.separator+ "screenshot.png";
			try {
				FileUtils.copyFile(file, new File(targetFile));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
