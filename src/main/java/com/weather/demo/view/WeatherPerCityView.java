package com.weather.demo.view;

import com.weather.demo.extservice.*;

import java.util.List;

public class WeatherPerCityView {
    private Main main;
    private String city_name;
    private List<WeatherList> weather = null;
    private Coord coord;
    private Integer visibility;
    private Wind wind;
    private String data_time_calculation;
    private Integer timezone;
    private List<SysList> System_Info = null;

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public String getData_time_calculation() {
        return data_time_calculation;
    }

    public void setData_time_calculation(String data_time_calculation) {
        this.data_time_calculation = data_time_calculation;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    public List<WeatherList> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherList> weather) {
        this.weather = weather;
    }

    public List<SysList> getSystem_Info() {
        return System_Info;
    }

    public void setSystem_Info(List<SysList> system_Info) {
        System_Info = system_Info;
    }
}

