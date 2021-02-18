package com.mm.model;

public class WeatherCity {

    private String cityFirst = null;
    private String citySecond = null;

    public String getCityFirst() {
        return cityFirst;
    }

    public void setCityFirst(String cityFirst) {
        this.cityFirst = cityFirst;
    }

    public String getCitySecond() {
        return citySecond;
    }

    public void setCitySecond(String citySecond) {
        this.citySecond = citySecond;
    }

    public WeatherCity(String cityFirst) {
        this.cityFirst = cityFirst;
    }

}
