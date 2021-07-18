package com.weather_reporting.webservices.utils;

import org.testng.asserts.SoftAssert;

public class Comparator {
	static SoftAssert softAssertion = new SoftAssert();
	public static void userCompareVariation(String temp_UI, String temp_API) {
		
		double ui_temp = covertStringtodouble(temp_UI.substring(0, temp_UI.length()-2));
        double api_temp_kelvin = covertStringtodouble(temp_API);
        double ui_temp_kelvin = convertTemperatureInStandardUnit(ui_temp);

        boolean kelvinDiff = compareDifference(ui_temp_kelvin,api_temp_kelvin);

        try {
        	softAssertion.assertTrue(kelvinDiff, "Assertion Failed:: Difference not matched");
           
        }catch (Exception exp){
          System.out.println(exp.getMessage());
           }
    }
	
	public static double convertTemperatureInStandardUnit(double temp_celcius)
	{
		return temp_celcius + 273.15;
				
	}

    public static double covertStringtodouble(String tempData)
    {
        return Double.parseDouble(tempData);
    }

    private static boolean compareDifference(double temp1, double temp2)
    {
        
        boolean flag = false;
        double valueDiff1 = temp1+2; 
        double valueDiff2 = temp1-2;
        if(temp2<=valueDiff1 && temp2 >= valueDiff2)
        {
            flag=true;
        }
        return flag;
    }

}
