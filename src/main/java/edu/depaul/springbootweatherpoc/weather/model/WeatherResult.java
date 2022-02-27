package edu.depaul.springbootweatherpoc.weather.model;

import java.util.Arrays;
import java.util.Date;

public class WeatherResult {

    private Date date;
    private Location location;
    private Weather currentConditions;
    private DayForecast tomorrowForecast;
    private DayForecast[] dayForecasts;
    private HourlyForecast[] hourlyForecast;
    private Precaution precaution;
    private Alert alert;
//        private Location[] recentlyViewLocations;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Weather getCurrentConditions() {
        return currentConditions;
    }

    public void setCurrentConditions(Weather currentConditions) {
        this.currentConditions = currentConditions;
    }

    public DayForecast getTomorrowForecast() {
        return tomorrowForecast;
    }

    public void setTomorrowForecast(DayForecast tomorrowForecast) {
        this.tomorrowForecast = tomorrowForecast;
    }

    public DayForecast[] getDayForecasts() {
        return dayForecasts;
    }

    public void setDayForecasts(DayForecast[] dayForecasts) {
        this.dayForecasts = dayForecasts;
    }

    public HourlyForecast[] getHourlyForecast() {
        return hourlyForecast;
    }

    public void setHourlyForecast(HourlyForecast[] hourlyForecast) {
        this.hourlyForecast = hourlyForecast;
    }

    public Precaution getPrecaution() {
        return precaution;
    }

    public void setPrecaution(Precaution precaution) {
        this.precaution = precaution;
    }

    public Alert getAlert() {
        return alert;
    }

    public void setAlert(Alert alert) {
        this.alert = alert;
    }

    @Override
    public String toString() {
        return "WeatherResult{" +
                "date=" + date +
                ", location=" + location +
                ", currentConditions=" + currentConditions +
                ", tomorrowForecast=" + tomorrowForecast +
                ", dayForecasts=" + Arrays.toString(dayForecasts) +
                ", hourlyForecast=" + Arrays.toString(hourlyForecast) +
                ", precaution=" + precaution +
                ", alert=" + alert +
                '}';
    }
}
