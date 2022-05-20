package org.sample.weather;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CommonMethods {
    private static final Logger logger = Logger.getLogger(CommonMethods.class);
    private final ApiCallUtil apiCallUtil = new ApiCallUtil();
    static CommonMethods commonMethods = new CommonMethods();

    public void getUrl(String envUrl, String option) {
        apiCallUtil.processCompleteWeatherData(envUrl, option);
    }

    public Object fetchData(String filePath, String option) {
        return apiCallUtil.getWeatherData(filePath, option);
    }

    public Object getJsonAsString(String filePath, String option) {
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader fileReader = null;
            Object obj;
            if (option.equals("goByLocalFileToWorkOffLine")) {
                try {
                    fileReader = new FileReader(filePath);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                try {
                    obj = jsonParser.parse(fileReader);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    obj = jsonParser.parse(filePath);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
            return obj;
        } finally {
            logger.info("In finally block");
        }
    }

    public void jsonParser(Object obj) {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) obj;
        String cod = (String) jsonObject.get("cod");
        logger.info("cod: " + cod);
        double message = (double) jsonObject.get("message");
        logger.info("message: " + message);
        long cnt = (long) jsonObject.get("cnt");
        logger.info("cnt: " + cnt);
        logger.info(jsonObject.get("city"));
        JSONObject jsonObjectCity = (JSONObject) jsonObject.get("city");
        logger.info("jsonObjectCity: " + jsonObjectCity);

        long city_id = (long) jsonObjectCity.get("id");
        logger.info("city_id: " + city_id);
        String city_name = (String) jsonObjectCity.get("name");
        logger.info("city_name: " + city_name);
        String city_country = (String) jsonObjectCity.get("country");
        logger.info("city_country: " + city_country);
        long city_population = (long) jsonObjectCity.get("population");
        logger.info("city_population: " + city_population);


        //Sample_list is an Array
        JSONArray jsonArrayList = (JSONArray) jsonObject.get("list");
//            logger.debug("jsonArray: "+jsonArrayList);
        try {
            for (int iCount = 0; iCount < jsonArrayList.size(); iCount++) {
                jsonObject = (JSONObject) jsonArrayList.get(iCount);
                JSONObject jsonObjectList = jsonObject;
                long list_dt = (long) jsonObjectList.get("dt");
                logger.info("list_dt: " + list_dt);
                String dt_txt = (String) jsonObjectList.get("dt_txt");
                logger.info("dt_txt: " + dt_txt);

                //list_main
                JSONObject jsonObjectMain = (JSONObject) jsonObjectList.get("main");
                logger.info("jsonObjectMain: " + jsonObjectMain);
                Object list_main_temp = jsonObjectMain.get("temp");
                logger.info("list_main_temp: " + list_main_temp);
                Object list_main_temp_min = jsonObjectMain.get("temp_min");
                logger.info("list_main_temp_min: " + list_main_temp_min);
                Object list_main_temp_max = jsonObjectMain.get("temp_max");
                logger.info("list_main_temp_max: " + list_main_temp_max);
                Object list_main_pressure = jsonObjectMain.get("pressure");
                logger.info("list_main_pressure: " + list_main_pressure);
                Object list_main_sea_level = jsonObjectMain.get("sea_level");
                logger.info("list_main_sea_level: " + list_main_sea_level);
                Object list_main_grnd_level = jsonObjectMain.get("grnd_level");
                logger.info("list_main_grnd_level: " + list_main_grnd_level);
                Object list_main_humidity = jsonObjectMain.get("humidity");
                logger.info("list_main_humidity: " + list_main_humidity);
                Object list_main_temp_kf = jsonObjectMain.get("temp_kf");
                logger.info("list_main_temp_kf: " + list_main_temp_kf);

                //list_weather -- is an Array
                JSONArray jsonArrayWeather = (JSONArray) jsonObjectList.get("weather");
                logger.info("jsonArrayWeather: " + jsonArrayWeather);
                try {
                    for (int jCount = 0; jCount < jsonArrayWeather.size(); jCount++) {
                        jsonObject = (JSONObject) jsonArrayWeather.get(jCount);
                        JSONObject jsonObjectWeather = jsonObject;
                        long list_weather_id = (long) jsonObjectWeather.get("id");
                        logger.info("list_weather_id: " + list_weather_id);
                        String list_weather_main = (String) jsonObjectWeather.get("main");
                        logger.info("list_weather_main: " + list_weather_main);
                        String list_weather_description = (String) jsonObjectWeather.get("description");
                        logger.info("list_weather_description: " + list_weather_description);
                        String list_weather_icon = (String) jsonObjectWeather.get("icon");
                        logger.info("list_weather_icon: " + list_weather_icon);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                //list_clouds
                JSONObject jsonObjectListClouds = (JSONObject) jsonObjectList.get("clouds");
                logger.info("jsonObjectListClouds: " + jsonObjectListClouds);
                long list_clouds = (long) jsonObjectListClouds.get("all");
                logger.info("list_clouds: " + list_clouds);

                //list_wind
                JSONObject jsonObjectListWind = (JSONObject) jsonObjectList.get("wind");
                logger.info("jsonObjectListWind: " + jsonObjectListWind);
                Object list_wind_speed = jsonObjectListWind.get("speed");
                logger.info("list_wind_speed: " + list_wind_speed);

                //list_sys
                JSONObject jsonObjectListSys = (JSONObject) jsonObjectList.get("sys");
                logger.info("jsonObjectListSys: " + jsonObjectListSys);
                String list_sys_pod = (String) jsonObjectListWind.get("pod");
                logger.info("list_sys_pod: " + list_sys_pod);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void CallByLocalFile(String option) {
        String filePath = "src/main/resources/sampleJson.json";
        File file = new File(filePath);
        logger.debug(file);
        commonMethods.getJsonAsString(filePath, option);
    }

    public static void CallByApi(String sampleUrl, String option) {
        commonMethods.getUrl(sampleUrl, option);
        ApiCallUtil apiCallUtil = new ApiCallUtil();
        apiCallUtil.processCompleteWeatherData(sampleUrl, option);

    }

    public void getDaysOfData(Object jsonData, Set<Integer> dayCounts) {
        JSONObject jsonObject = (JSONObject) jsonData;
        JSONArray jsonArrayList = (JSONArray) jsonObject.get("list");

        try {
            for (int iCount = 0; iCount < jsonArrayList.size(); iCount++) {
                jsonObject = (JSONObject) jsonArrayList.get(iCount);
                JSONObject jsonObjectList = jsonObject;

                String dt_txt = (String) jsonObjectList.get("dt_txt");
                Date date = parseDate(dt_txt, ApplicationConstants.DATE_FORMAT_LOCAL_DATETIME);
                logger.info("date: " + date);
                Calendar calendarInitial = Calendar.getInstance();
                calendarInitial.setTime(date);
                logger.info("initial time: " + calendarInitial.getTime());

                int dayOfMonth = getDayOfMonth(calendarInitial);
                dayCounts.add(dayOfMonth);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getDayOfMonth(Calendar calendar) {
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        logger.info("day: " + day);
        return day;
    }

    public static Date parseDate(String date, String format) throws java.text.ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.parse(date);
    }

    public Set verifyAllHoursPresence(Map<Integer, List<Integer>> dayHourMap) {
        Set presentHours = new HashSet();
        Set missingHours = new HashSet();

        try {
            for (Map.Entry<Integer, List<Integer>> entry : dayHourMap.entrySet()) {
                int dateField = entry.getKey();
                int hourListSize = entry.getValue().size();
                logger.info(dateField + ", " + hourListSize);
                //logic to check missing hours

                for (int i = 0; i < 24; i++) {
                    if (entry.getValue().contains(i)) {
                        presentHours.add(i);
                    } else {
                        missingHours.add(i);
                    }
                }
                logger.info("present hours = " + presentHours);
                logger.info("missing hours = " + missingHours);
                Assert.assertTrue(presentHours.size() + missingHours.size() == 24, "forecast is not in hourly interval");
                Assert.assertFalse(presentHours.size() < 23, "missing hours are: " + missingHours + " on date " + dateField);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return missingHours;
    }

    public Map<Integer, Integer> getHoursDataInMap(Object jsonData) throws java.text.ParseException {
        JSONObject jsonObject = (JSONObject) jsonData;
        JSONArray jsonArrayList = (JSONArray) jsonObject.get("list");
        int day = 0;
        int hour = 0;
        List<WeatherApiResponse> res = new ArrayList<>();
        HashMap map = new HashMap();
        HashMap hashMap = new HashMap();

        for (int iCount = 0; iCount < jsonArrayList.size(); iCount++) {
            jsonObject = (JSONObject) jsonArrayList.get(iCount);
            JSONObject jsonObjectList = jsonObject;

            String dt_txt = (String) jsonObjectList.get("dt_txt");

            Date date = parseDate(dt_txt, ApplicationConstants.DATE_FORMAT_LOCAL_DATETIME);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            day = calendar.get(Calendar.DAY_OF_MONTH);
            hour = calendar.get(Calendar.HOUR_OF_DAY);
            res.add(new WeatherApiResponse(day, hour));
        }
        for (WeatherApiResponse tempResp : res) {
            hashMap = filterMapData(tempResp.getDt_txt_day(), tempResp.getDt_txt_hour(), map);
        }
        return hashMap;
    }

    private HashMap filterMapData(Integer key, Integer value, HashMap map) {
        ArrayList tempList;
        try {
            if (map.containsKey(key)) {
                tempList = (ArrayList) map.get(key);
                if (tempList == null) {
                    tempList = new ArrayList();
                }
                tempList.add(value);
            } else {
                tempList = new ArrayList();
                tempList.add(value);
            }
            map.put(key, tempList);
            logger.info(map);
        } catch (ClassCastException cce) {
        }
        return map;
    }

}
