package com.example.sodiqoladeni.openweather;

import com.google.gson.annotations.SerializedName;

public class WeatherDesc {

    @SerializedName("description")
    private String weatherDesc;

    public String getWeatherDesc() {
        return weatherDesc;
    }
}
