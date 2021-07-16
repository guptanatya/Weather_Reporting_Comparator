package com.weather_reporting.ui.actions;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;



public class HomePage {
	
    WebDriver driver;
    
	SoftAssert softAssertion= new SoftAssert();

	@FindBy(css = "input.search-input")
	WebElement searchLocation;
	
	@FindBy(css = ".header-loc")
	WebElement locationHeader;
	
	@FindBy(css =".banner-button.policy-accept")
    WebElement acceptCookie;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	
	public void verifyOnHomePage(String homePageTitle)
	{
		softAssertion.assertEquals(driver.getTitle(), homePageTitle, "Assertion Failed: User is not on Home Page");
		
	}
	
	public void searchForLocation(String location)
	{
		searchLocation.sendKeys(location);
		searchLocation.sendKeys(Keys.ENTER);
		softAssertion.assertTrue(locationHeader.getText().contains(location), "Assertion Failed: Location not matched");
		
	}
	
	public void clickPopup()
	{
		acceptCookie.click();
		Reporter.log("[INFO]:: accept I understand");
		
	}
	
	 
}
