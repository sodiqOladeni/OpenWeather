package com.example.sodiqoladeni.openweather;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sodiqoladeni.openweather.databinding.FragmentWeatherBinding;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherFragment extends Fragment {

    private FragmentWeatherBinding binding;
    private String currentDateTimeString;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_weather, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        getCurrentWeather(Constants.APIKEY, "lagos");
    }

    private void getCurrentWeather(String apiKey, String city) {
        ClientEndPoint service = NetworkService.getNetworkRequestInstance().create(ClientEndPoint.class);
        Call<WeatherModel> call = service.getCurrentWeather(apiKey, city);

        call.enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                binding.progressbar.setVisibility(View.GONE);
                try {
                    if (response.body() != null){
                        WeatherModel responses = response.body();
                        binding.dateTime.setText(currentDateTimeString);
                        binding.temperature.setText(String.format("%sc", responses.getWeatherTempMain().getWeatherTemp()));
                        binding.desc.setText(responses.getWeatherDescList().get(0).getWeatherDesc());
                        binding.windspeed.setText(String.format("%smph", responses.getWeatherSpeedWind().getTemp()));
                    }
                }catch (NullPointerException e){
                    e.getMessage();
                }
            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {
                binding.progressbar.setVisibility(View.GONE);
                Log.d("MainActivity", "onFailure: ");
            }
        });
    }
}
