# Weather_Reporting_Comparator

#System Requirement : JDK 1.8 and above, Maven 3.8.1, Chrome Browser version >=90

#Execution Steps : Please follow the instructions to execute the test on local:
      1. Checkout the code from GIT (https://github.com/guptanatya/Weather_Reporting_Comparator.git)
      2. From any IDE, execute "WeatherReportingComparator.java" file to start the execution from TestNG present under the package "src\test\java\com\weather_reporting\tests"
      3. To execute the test through maven, use the command "mvn clean verify test -DTestNG=WeatherComparator.xml"

#Execution Flow
     1. Store all the weather information of a city from (https://www.accuweather.com/)
     2. Call API (https://openweathermap.org/current) By City Name to store the weather data 
     3. Compare the temperature data of both UI and API
     4. Test Data stored in a "testData.properties"

#Results :
     1. After the execution, ./test-output/emailable-report.html (execution through Test NG)
     2. ./target/surefire-reports/emailable-report.html (execution through Maven)