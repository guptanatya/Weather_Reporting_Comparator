package com.weather_reporting.webservices.weather;


import org.json.JSONObject;
import org.testng.asserts.SoftAssert;

import com.weather_reporting.webservices.utils.Constants;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class WeatherAPI {

	static SoftAssert softAssertion = new SoftAssert();

	public static JSONObject getWeatherInfo(String city, String appkey, int expectedStatusCode) {

		RestAssured.baseURI = Constants.BASE_URL;
		Response response = RestAssured.given().queryParams("q", city, "appid", appkey).when().get(Constants.weatherEndPoint);

		softAssertion.assertEquals(response.getStatusCode(), expectedStatusCode,
				"Assertion Failed:: Status Code not matched" + response.getStatusCode());

		return new JSONObject(response.getBody().asString());

	}

	public static JSONObject getWeatherInfoByCityId(String cityId, String appkey, String expectedStatusCode)  {

		RestAssured.baseURI = Constants.BASE_URL;
		Response response = RestAssured.given().header("Content-Type", "application/json")
				.queryParams("id", cityId, "appid", appkey).when().get(Constants.weatherEndPoint);

		softAssertion.assertEquals(response.getStatusCode(), expectedStatusCode,
				"Assertion Failed:: Status Code not matched" + response.getStatusCode());

		return new JSONObject(response.getBody().asString());

	}

}
