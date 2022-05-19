package org.sample.weather;

import java.util.List;

public class Weather {
    private String cod;
    private double message;
    private long cnt;
    private List<WeatherList> list;
    private WeatherCity city;

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

    public List<WeatherList> getList() {
        return list;
    }

    public void setList(List<WeatherList> list) {
        this.list = list;
    }

    public WeatherCity getCity() {
        return city;
    }

    public void setCity(WeatherCity city) {
        this.city = city;
    }
}
