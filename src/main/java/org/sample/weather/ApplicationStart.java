package org.sample.weather;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;

import static org.sample.weather.CommonMethods.CallByApi;
import static org.sample.weather.CommonMethods.CallByLocalFile;

public class ApplicationStart {
    private static final Logger logger = Logger.getLogger(ApplicationStart.class);

    public static void main(String[] args) {
        logger.info("Application started");
        logger.warn("Take care of Debug logs, it will consume resources..make sure to turn it off in Prod.. ");

        String myOptions = "goByLocalFileToWorkOffLine";

        final String sampleUrl = "https://samples.openweathermap.org/data/2.5/forecast/hourly?q=London,us&appid=b6907d289e10d714a6e88b30761fae22";
        switch (myOptions) {
            case "goByApi":
                CallByApi(sampleUrl, myOptions);
                break;
            case "goByLocalFileToWorkOffLine":
                CallByLocalFile(myOptions);
                break;
        }
        logger.debug("end of program");
    }

}
