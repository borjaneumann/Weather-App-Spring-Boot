package com.weather.demo.service;

import com.weather.demo.extservice.SysList;
import com.weather.demo.extservice.WeatherList;
import com.weather.demo.extservice.WeatherPerCityName;
import com.weather.demo.feign.WeatherApiClient;
import com.weather.demo.view.WeatherPerCityView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WeatherPerCityService {

    @Autowired
    WeatherApiClient weatherApiClient;

    @Value("${weather.api_key}")
    private String api_key;

    public WeatherPerCityView getWeatherPerCityView(String city){

        WeatherPerCityView weatherPerCityView= new WeatherPerCityView();

        WeatherPerCityName weatherPerCityNameDto= weatherApiClient.getWeatherPerCity(city,api_key,"metric");

        //loose items
        weatherPerCityView.setCity_name(weatherPerCityNameDto.getName());
        weatherPerCityView.setMain(weatherPerCityNameDto.getMain());
        weatherPerCityView.setVisibility(weatherPerCityNameDto.getVisibility());
        weatherPerCityView.setWind(weatherPerCityNameDto.getWind());
        weatherPerCityView.setTimezone(weatherPerCityNameDto.getTimezone()/3600);

        //Weather selection
        List<WeatherList>weatherList= new ArrayList<>();
        WeatherList weatherListObj = new WeatherList();
        weatherListObj.setMain(weatherPerCityNameDto.getWeather().get(0).getMain());
        weatherListObj.setDescription(weatherPerCityNameDto.getWeather().get(0).getDescription());
        weatherListObj.setIcon(weatherPerCityNameDto.getWeather().get(0).getIcon());
        weatherList.add(weatherListObj);
        weatherPerCityView.setWeather(weatherList);

        //Coord
        weatherPerCityView.setCoord(weatherPerCityNameDto.getCoord());

        //sys
        List<SysList> sysListList=new ArrayList<>();
        SysList sysListObj = new SysList();

        sysListObj.setCountry(weatherPerCityNameDto.getSys().getCountry());

        //sunset
        Long sunset = Long.valueOf(weatherPerCityNameDto.getSys().getSunset());
        //let us simplify Long gmt =Long.valueOf((weatherPerCityNameDto.getTimezone()/3600)*3600000);
        Long gmt =Long.valueOf((weatherPerCityNameDto.getTimezone())*1000);
        Date sunsetTime = new Date((sunset*1000)+gmt);
        SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss a ");
        SimpleDateFormat et = new SimpleDateFormat("hh:mm:ss a zzz");


        //sunrise
        Long sunrise = Long.valueOf(weatherPerCityNameDto.getSys().getSunrise());
        Date sunriseTime = new Date((sunrise*1000)+gmt);

        sysListObj.setSunrise_local_time(ft.format(sunriseTime));
        sysListObj.setSunset_local_time(ft.format(sunsetTime));
        sysListList.add(sysListObj);
        weatherPerCityView.setSystem_Info(sysListList);

        //Time of data calculation
        Long dataTimeCal = Long.valueOf(weatherPerCityNameDto.getDt());
        Date dataTime = new Date(dataTimeCal*1000);
        weatherPerCityView.setData_time_calculation(et.format(dataTime));

        return weatherPerCityView;
    }
}
