package com.example.sodiqoladeni.openweather;

import com.google.gson.annotations.SerializedName;

public class TempearatureModel {
    @SerializedName("temp")
    private String weatherTemp;

    public String getWeatherTemp() {
        return weatherTemp;
    }
}
