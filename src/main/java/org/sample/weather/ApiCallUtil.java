package org.sample.weather;


import io.restassured.RestAssured;
import org.apache.log4j.Logger;

public class ApiCallUtil {
    private static final Logger logger = Logger.getLogger(ApiCallUtil.class);

    public Object getWeatherData(String url, String option) {
        String filePath = callGetApi(url);
        CommonMethods commonMethods = new CommonMethods();
        return commonMethods.getJsonAsString(filePath, option);
    }

    public void processCompleteWeatherData(String url, String option) {
        CommonMethods commonMethods = new CommonMethods();

        commonMethods.jsonParser(getWeatherData(url, option));
    }

    private String callGetApi(String url) {
        int statusResponse = RestAssured.given().get(url).statusCode();
        logger.info("API status: " + statusResponse);
        return RestAssured.given().get(url).asString();
    }

}
