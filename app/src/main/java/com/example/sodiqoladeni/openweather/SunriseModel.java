package com.example.sodiqoladeni.openweather;

import com.google.gson.annotations.SerializedName;

public class SunriseModel {

    @SerializedName("sunrise")
    private String sunriseTime;
    @SerializedName("sunset")
    private String sunsetTime;

    public String getSunriseTime() {
        return sunriseTime;
    }

    public String getSunsetTime() {
        return sunsetTime;
    }
}
