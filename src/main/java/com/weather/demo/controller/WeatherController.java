package com.weather.demo.controller;

import com.weather.demo.extservice.WeatherPerCityName;
import com.weather.demo.feign.WeatherApiClient;
import com.weather.demo.service.WeatherPerCityService;
import com.weather.demo.view.WeatherPerCityView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class WeatherController {

    @Value("${weather.api_key}")
    private String api_key;
    @Autowired
    private WeatherApiClient weatherApiClient;
    @Autowired
    private WeatherPerCityService weatherPerCityService;

    //------------------Weather per city---------------------------//

    @GetMapping("weather/{city}")
    public WeatherPerCityName getWeatherResponse (@PathVariable String city){

        return weatherApiClient.getWeatherPerCity(city,api_key, "metric");
    }
    @GetMapping("weather/mvc/{city}")
    public WeatherPerCityView getWeatherResponseView (@PathVariable String city){
        return weatherPerCityService.getWeatherPerCityView(city);
    }
}


