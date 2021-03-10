package com.weather.demo.feign;


import com.weather.demo.extservice.WeatherPerCityName;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//https://api.openweathermap.org/data/2.5/weather?id=833&appid=2c5b139e2edfa890e84be1f2e4a56b2f

@FeignClient(url="https://api.openweathermap.org", name="weatherAPIclient" )
public interface WeatherApiClient {

    @GetMapping("/data/2.5/weather")
    WeatherPerCityName getWeatherPerCity(@RequestParam(value="q") String city,
                              @RequestParam(value= "appid")String weather_key,
                              @RequestParam(value= "units")String units);

}
