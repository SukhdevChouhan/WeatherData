import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.sample.weather.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.*;

public class TestWeatherData extends Login {
    public Logger logger = Logger.getLogger(TestWeatherData.class);
    protected Properties weatherProperties = new Properties();
    CommonMethods commonMethods = new CommonMethods();
    Object jsonData;
    Weather weatherData;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        launchUrl(new Object() {
        }.getClass().getName());
        weatherProperties = new Properties();
        weatherProperties = BaseUtil.loadMenuOptionsConfigFile("WeatherData.properties", weatherProperties);
        jsonData = commonMethods.fetchData(weatherProperties.getProperty("url"), "goByApi");
        if (jsonData != null) {
            weatherData = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false).convertValue(jsonData, Weather.class);
        }
    }

    @Test(description = "Is the response contains 4 days of data", enabled = true, groups = "hour Test")
    public void TC01_Is_the_response_contains_4_days_of_data() {
        Set<Integer> dayCount = new HashSet<>();
        commonMethods.getDaysOfData(jsonData, dayCount);
        logger.info("Day of data: " + dayCount);
        Assert.assertTrue(dayCount.size() > 4, "Weather data is not present for more then 4 days");
    }

    @Test(description = "Is all the forecast in the hourly interval ( no hour should be missed )", enabled = true, groups = "hour Test")
    public void TC02_Is_all_the_forecast_in_the_hourly_interval_and_no_hour_should_be_missed() throws ParseException {

        HashMap hp = (HashMap) commonMethods.getHoursDataInMap(jsonData);
        commonMethods.verifyAllHoursPresence(hp);
    }

    @Test(description = "For all 4 days, the temp should not be less than temp_min and not more than temp_max", enabled = true, groups = "Temperature Test")
    public void TC03_For_all_4_days_the_temp_should_not_be_less_than_temp_min_and_not_more_than_temp_max() throws ParseException {
//        commonMethods.getTemperatureData(jsonData);
        Assert.assertNotNull(weatherData, "Weather is not available.");
        Assert.assertTrue(weatherData.getList() != null && weatherData.getList().size() > 0, "No weather data available to read");
        boolean result = true;
        for (WeatherList listObj : weatherData.getList()) {
            WeatherMain main = listObj.getMain();
            if (main.getTemp() < main.getTemp_min()) {
                logger.info((main.getTemp() - main.getTemp_min()) + " temp. difference issue on date:" + listObj.getDt_txt());
                result = false;
            }
            if (main.getTemp() > main.getTemp_max()) {
                logger.info((main.getTemp() - main.getTemp_max()) + " temp. difference issue on date:" + listObj.getDt_txt());
                result = false;
            }
        }
        Assert.assertTrue(result, "The temperature has been fluctuated.");
    }

    @Test(description = "If the weather id is 500, the description should be light rain", enabled = true, groups = "Temperature Test")
    public void TC04_If_the_weather_id_is_500_the_description_should_be_light_rain() {
        Assert.assertNotNull(weatherData, "Weather is not available.");
        Assert.assertTrue(weatherData.getList() != null && weatherData.getList().size() > 0, "No weather data available to read");
        for (WeatherList listObj : weatherData.getList()) {
            for (WeatherInternal internal : listObj.getWeather()) {
                if (internal.getId() == 500) {
                    Assert.assertEquals(internal.getDescription(), "light rain", "Failed due to description mismatched");
                }
            }
        }
    }

    @Test(description = "If the weather id is 800, the description should be a clear sky", enabled = true, groups = "Temperature Test")
    public void TC05_If_the_weather_id_is_800_the_description_should_be_a_clear_sky() {
        Assert.assertNotNull(weatherData, "Weather is not available.");
        Assert.assertTrue(weatherData.getList() != null && weatherData.getList().size() > 0, "No weather data available to read");
        for (WeatherList listObj : weatherData.getList()) {
            for (WeatherInternal internal : listObj.getWeather()) {
                if (internal.getId() == 800) {
                    Assert.assertEquals(internal.getDescription(), "clear sky", "Failed due to description mismatched");
                }
            }
        }
    }
}