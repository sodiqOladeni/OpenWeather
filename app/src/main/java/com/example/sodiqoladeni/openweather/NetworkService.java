package com.example.sodiqoladeni.openweather;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {


    public static Retrofit networkRequestInstance;
    private static final String BASED_URL = "http://api.openweathermap.org/";

    public static Retrofit getNetworkRequestInstance() {
        OkHttpClient.Builder okhttp  = new  OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (BuildConfig.DEBUG) {
            okhttp.addInterceptor(logging);
        }

        if (networkRequestInstance == null)
            networkRequestInstance = new Retrofit.Builder().
                    baseUrl(BASED_URL).
                    addConverterFactory(GsonConverterFactory.create()).
                    client(okhttp.build()).
                    build();
        return networkRequestInstance;
    }

    public NetworkService() {}
}
