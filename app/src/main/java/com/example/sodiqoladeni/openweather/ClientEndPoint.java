package com.example.sodiqoladeni.openweather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ClientEndPoint {

    @GET("data/2.5/weather")
    Call<WeatherModel> getCurrentWeather(
            @Query("APPID") String apikey,
            @Query("q") String city
    );
}
