package edu.depaul.springbootweatherpoc.weather.model;

import java.util.Date;

public class HourlyForecast {

    private Enum day;
    private Date date;
    private int hour;
    private Weather weather;

    public Enum getDay() {
        return day;
    }

    public void setDay(Enum day) {
        this.day = day;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }
}
