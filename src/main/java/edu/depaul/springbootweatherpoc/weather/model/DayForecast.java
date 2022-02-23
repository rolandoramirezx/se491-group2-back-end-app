package edu.depaul.springbootweatherpoc.weather.model;

import java.util.Date;

public class DayForecast {

    private String day;
    private Date date;
    private Weather weather;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

}
