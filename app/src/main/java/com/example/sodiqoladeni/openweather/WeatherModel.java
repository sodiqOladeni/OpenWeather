package com.example.sodiqoladeni.openweather;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherModel {
    @SerializedName("weather")
    private List<WeatherDesc> weatherDescList;

    @SerializedName("main")
    private TempearatureModel weatherTempMain;

    @SerializedName("wind")
    private WindModel weatherSpeedWind;

    @SerializedName("sys")
    private SunriseModel sys;


    public List<WeatherDesc> getWeatherDescList() {
        return weatherDescList;
    }

    public TempearatureModel getWeatherTempMain() {
        return weatherTempMain;
    }

    public WindModel getWeatherSpeedWind() {
        return weatherSpeedWind;
    }

    public SunriseModel getSys() {
        return sys;
    }
}
