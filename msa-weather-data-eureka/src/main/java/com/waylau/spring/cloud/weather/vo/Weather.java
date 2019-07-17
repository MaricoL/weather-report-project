package com.waylau.spring.cloud.weather.vo;

import java.io.Serializable;
import java.util.List;

public class Weather implements Serializable {

    private String city;
    private String aqi;
    private String ganmao;
    private String wendu;
    private Yesterday yesterday;
    private List<Forecast> forecast;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    public Yesterday getYesterday() {
        return yesterday;
    }

    public void setYesterday(Yesterday yesterday) {
        this.yesterday = yesterday;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", aqi='" + aqi + '\'' +
                ", ganmao='" + ganmao + '\'' +
                ", wendu='" + wendu + '\'' +
                ", yesterday=" + yesterday +
                ", forecasts=" + forecast +
                '}';
    }
}
