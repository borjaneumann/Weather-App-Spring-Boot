package com.weather.demo.extservice;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class SysList {
    private String country;
    private String sunrise_local_time;
    private String sunset_local_time;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSunrise_local_time() {
        return sunrise_local_time;
    }

    public void setSunrise_local_time(String sunrise_local_time) {
        this.sunrise_local_time = sunrise_local_time;
    }

    public String getSunset_local_time() {
        return sunset_local_time;
    }

    public void setSunset_local_time(String sunset_local_time) {
        this.sunset_local_time = sunset_local_time;
    }
}
