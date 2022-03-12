package edu.depaul.springbootweatherpoc.model;

import org.json.simple.JSONObject;

public class OpenWeatherResponse {

    public Geolocation getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(Geolocation geolocation) {
        this.geolocation = geolocation;
    }

    public JSONObject getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(JSONObject weatherData) {
        this.weatherData = weatherData;
    }

    private Geolocation geolocation;
    private JSONObject weatherData;
}
