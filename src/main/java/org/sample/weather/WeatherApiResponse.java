package org.sample.weather;

public class WeatherApiResponse {
    private String cod;
    private double message;
    private long cnt;
    private long city_id;
    private String city_name;
    private String city_country;
    private long city_population;
    private long list_dt;
    private String dt_txt;
    private Object list_main_temp;
    private Object list_main_temp_min;
    private Object list_main_temp_max;
    private Object list_main_pressure;
    private Object list_main_sea_level;
    private Object list_main_grnd_level;
    private Object list_main_humidity;
    private Object list_main_temp_kf;
    private long list_weather_id;
    private String list_weather_main;
    private String list_weather_description;
    private String list_weather_icon;
    private long list_clouds;
    private Object list_wind_speed;
    private String list_sys_pod;
    private int dt_txt_day;
    private int dt_txt_hour;

    private long list_main_temp_long;
    private double list_main_temp_double;
    private int list_main_temp_int;

    public long getList_main_temp_long() {
        return list_main_temp_long;
    }

    public void setList_main_temp_long(long list_main_temp_long) {
        this.list_main_temp_long = list_main_temp_long;
    }

    public double getList_main_temp_double() {
        return list_main_temp_double;
    }

    public void setList_main_temp_double(double list_main_temp_double) {
        this.list_main_temp_double = list_main_temp_double;
    }

    public int getList_main_temp_int() {
        return list_main_temp_int;
    }

    public void setList_main_temp_int(int list_main_temp_int) {
        this.list_main_temp_int = list_main_temp_int;
    }

    public WeatherApiResponse() {
    }

    public WeatherApiResponse(Integer dt_txt_day, Integer dt_txt_hour) {
        this.dt_txt_day = dt_txt_day;
        this.dt_txt_hour = dt_txt_hour;
    }

    public WeatherApiResponse(Object list_main_temp, Object list_main_temp_min, Object list_main_temp_max, String dt_txt) {
        this.list_main_temp = list_main_temp;
        this.list_main_temp_min = list_main_temp_min;
        this.list_main_temp_max = list_main_temp_max;
        this.dt_txt = dt_txt;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public long getCnt() {
        return cnt;
    }

    public void setCnt(long cnt) {
        this.cnt = cnt;
    }

    public long getCity_id() {
        return city_id;
    }

    public void setCity_id(long city_id) {
        this.city_id = city_id;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getCity_country() {
        return city_country;
    }

    public void setCity_country(String city_country) {
        this.city_country = city_country;
    }

    public long getCity_population() {
        return city_population;
    }

    public void setCity_population(long city_population) {
        this.city_population = city_population;
    }

    public long getList_dt() {
        return list_dt;
    }

    public void setList_dt(long list_dt) {
        this.list_dt = list_dt;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    public Object getList_main_temp() {
        return list_main_temp;
    }

    public void setList_main_temp(Object list_main_temp) {
        this.list_main_temp = list_main_temp;
    }

    public Object getList_main_temp_min() {
        return list_main_temp_min;
    }

    public void setList_main_temp_min(Object list_main_temp_min) {
        this.list_main_temp_min = list_main_temp_min;
    }

    public Object getList_main_temp_max() {
        return list_main_temp_max;
    }

    public void setList_main_temp_max(Object list_main_temp_max) {
        this.list_main_temp_max = list_main_temp_max;
    }

    public Object getList_main_pressure() {
        return list_main_pressure;
    }

    public void setList_main_pressure(Object list_main_pressure) {
        this.list_main_pressure = list_main_pressure;
    }

    public Object getList_main_sea_level() {
        return list_main_sea_level;
    }

    public void setList_main_sea_level(Object list_main_sea_level) {
        this.list_main_sea_level = list_main_sea_level;
    }

    public Object getList_main_grnd_level() {
        return list_main_grnd_level;
    }

    public void setList_main_grnd_level(Object list_main_grnd_level) {
        this.list_main_grnd_level = list_main_grnd_level;
    }

    public Object getList_main_humidity() {
        return list_main_humidity;
    }

    public void setList_main_humidity(Object list_main_humidity) {
        this.list_main_humidity = list_main_humidity;
    }

    public Object getList_main_temp_kf() {
        return list_main_temp_kf;
    }

    public void setList_main_temp_kf(Object list_main_temp_kf) {
        this.list_main_temp_kf = list_main_temp_kf;
    }

    public long getList_weather_id() {
        return list_weather_id;
    }

    public void setList_weather_id(long list_weather_id) {
        this.list_weather_id = list_weather_id;
    }

    public String getList_weather_main() {
        return list_weather_main;
    }

    public void setList_weather_main(String list_weather_main) {
        this.list_weather_main = list_weather_main;
    }

    public String getList_weather_description() {
        return list_weather_description;
    }

    public void setList_weather_description(String list_weather_description) {
        this.list_weather_description = list_weather_description;
    }

    public String getList_weather_icon() {
        return list_weather_icon;
    }

    public void setList_weather_icon(String list_weather_icon) {
        this.list_weather_icon = list_weather_icon;
    }

    public long getList_clouds() {
        return list_clouds;
    }

    public void setList_clouds(long list_clouds) {
        this.list_clouds = list_clouds;
    }

    public Object getList_wind_speed() {
        return list_wind_speed;
    }

    public void setList_wind_speed(Object list_wind_speed) {
        this.list_wind_speed = list_wind_speed;
    }

    public String getList_sys_pod() {
        return list_sys_pod;
    }

    public void setList_sys_pod(String list_sys_pod) {
        this.list_sys_pod = list_sys_pod;
    }

    public int getDt_txt_day() {
        return dt_txt_day;
    }

    public void setDt_txt_day(int dt_txt_day) {
        this.dt_txt_day = dt_txt_day;
    }

    public int getDt_txt_hour() {
        return dt_txt_hour;
    }

    public void setDt_txt_hour(int dt_txt_hour) {
        this.dt_txt_hour = dt_txt_hour;
    }


}
