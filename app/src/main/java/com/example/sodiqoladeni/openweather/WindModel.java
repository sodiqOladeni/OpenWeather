package com.example.sodiqoladeni.openweather;

import com.google.gson.annotations.SerializedName;

public class WindModel {

    @SerializedName("speed")
    private String speed;

    public String getTemp() {
        return speed;
    }
}
