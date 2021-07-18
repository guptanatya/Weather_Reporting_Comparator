package com.weather_reporting.ui.actions;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.weather_reporting.ui.utils.ConfigFileReader;

public class CurrentWeatherReportPage {

	WebDriver driver;

	SoftAssert softAssertion = new SoftAssert();

	@FindBy(css = ".spaced-content .phrase")
	WebElement txt_moreDetails;

	@FindBy(css = ".content-module.subnav-pagination > div")
	WebElement txt_dayMonthDate;

	@FindBy(css = "div.temp")
	WebElement txt_temp;

	public WebElement getDynamicInfo(String value) {
		return driver.findElement(By.xpath("//div[@class='detail-item spaced-content']//div[contains(text(),'" + value
				+ "')]//following-sibling::div"));
	}

	public CurrentWeatherReportPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyCurrentDayAndTime() {

		txt_moreDetails.click();
		driver.navigate().back();
		txt_moreDetails.click();
		String expectedDate = getCurrentDay_Month_Date();
		softAssertion.assertEquals(txt_dayMonthDate.getText(), expectedDate,
				"Assertion Failed:: Current Date not matched with expected date");

	}

	public String getCurrentDay_Month_Date() {
		LocalDate currentdate = LocalDate.now();
		DayOfWeek dayOfWeek = currentdate.getDayOfWeek();
		int currentDay = currentdate.getDayOfMonth();
		Month currentMonth = currentdate.getMonth();
		String currentDate = dayOfWeek + ", " + currentMonth + " " + currentDay;

		return currentDate;
	}

	public String getInformationOfCurrentWeather(String weatherParameter) {
		return getDynamicInfo(weatherParameter).getText();
	}

	public String getTemperature() {
		return txt_temp.getText();
	}

	public Map<String, String> storeInformationOfWeather() {
		String[] weatherKeys = { "Wind", "Wind Gusts", "Humidity", "Indoor Humidity", "Dew Point", "Pressure",
				"Cloud Cover", "Visibility", "Cloud Ceiling" };
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Temperature", getTemperature());
		for (String string : weatherKeys) {
			map.put(string, getInformationOfCurrentWeather(string));
		}
		return map;
	}

}
