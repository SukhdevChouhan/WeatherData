package org.sample.weather;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherList {

    private Date dt;
    private WeatherMain main;
    private List<WeatherInternal> weather;
    @JsonIgnore
    private WeatherCloud cloud;
    private WeatherWind wind;
    private WeatherSys sys;
    private String dt_txt;

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public WeatherMain getMain() {
        return main;
    }

    public void setMain(WeatherMain main) {
        this.main = main;
    }

    public List<WeatherInternal> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherInternal> weather) {
        this.weather = weather;
    }

    public WeatherCloud getCloud() {
        return cloud;
    }

    public void setCloud(WeatherCloud cloud) {
        this.cloud = cloud;
    }

    public WeatherWind getWind() {
        return wind;
    }

    public void setWind(WeatherWind wind) {
        this.wind = wind;
    }

    public WeatherSys getSys() {
        return sys;
    }

    public void setSys(WeatherSys sys) {
        this.sys = sys;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }
}
