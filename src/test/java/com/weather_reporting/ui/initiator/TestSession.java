package com.weather_reporting.ui.initiator;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import com.weather_reporting.ui.actions.CurrentWeatherReportPage;
import com.weather_reporting.ui.actions.HomePage;
import com.weather_reporting.ui.utils.ConfigFileReader;

public class TestSession {

	protected WebDriver driver;
	public HomePage homepage;
	public CurrentWeatherReportPage currentWeatherReportPage;

	private void initPage() {
		homepage = new HomePage(driver);
		currentWeatherReportPage = new CurrentWeatherReportPage(driver);
	}

	public TestSession(String testname) {

		System.out.println("Test Name: " + testname);
		configureBrowser();
		initPage();

	}

	private Map<String, String> getSessionConfig() {
		String[] configKeys = { "browser", "timeout", "email", "driverpath", "baseurl" };
		Map<String, String> config = new HashMap<String, String>();
		for (String string : configKeys) {
			config.put(string, ConfigFileReader.getProperty(string));
		}
		return config;
	}

	private void configureBrowser() {
		driver = getDriver(getSessionConfig().get("browser"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(getSessionConfig().get("timeout")),
				TimeUnit.SECONDS);
	}

	public WebDriver getDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome"))
			return getChromeDriver(ConfigFileReader.getProperty("driverpath"));

		return getFirefoxDriver(ConfigFileReader.getProperty("driverpath"));

	}

	private static WebDriver getChromeDriver(String driverpath) {
		System.setProperty("webdriver.chrome.driver", driverpath + "/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		return new ChromeDriver(options);
	}

	private static WebDriver getFirefoxDriver(String driverpath) {
		System.setProperty("webdriver.gecko.driver", driverpath + "/geckodriver.exe");
		return new FirefoxDriver();
	}

	public void launchApplication(String loginUrl) {
		Reporter.log("\nThe application url is :- " + loginUrl);

		Reporter.log("The test browser is :- " + getSessionConfig().get("browser"));
		driver.manage().window().maximize();
		driver.get(loginUrl);

	}

	public void stepMessage(String testStepName) {
		Reporter.log("***** STARTING TEST STEP:- " + testStepName.toUpperCase() + " *****", true);

	}

	public void closeBrowserSession() {
		driver.quit();
	}

}
