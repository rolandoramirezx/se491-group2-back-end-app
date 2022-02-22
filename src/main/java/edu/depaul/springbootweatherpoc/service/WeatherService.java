package edu.depaul.springbootweatherpoc.service;

import edu.depaul.springbootweatherpoc.util.WeatherUtil;
import edu.depaul.springbootweatherpoc.weather.model.Weather;
import edu.depaul.springbootweatherpoc.weather.model.WeatherResult;
import edu.depaul.springbootweatherpoc.weather.openweather.OpenWeatherApiRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    private final OpenWeatherApiRepository openWeatherApiRepository;

    public WeatherService(OpenWeatherApiRepository openWeatherApiRepository) {
        this.openWeatherApiRepository = openWeatherApiRepository;
    }

    public WeatherResult getWeather(String city) {
        WeatherUtil weatherUtil = new WeatherUtil();
        JSONObject res = this.openWeatherApiRepository.getWeather(city);
        WeatherResult weatherResult = new WeatherResult();
        weatherResult = weatherUtil.processOpenWeatherResponse(res);
        return weatherResult;
    }

    public JSONObject getWeather(int zipCode) {
        return this.openWeatherApiRepository.getWeather(zipCode);
    }

    public JSONObject getWeather(Double lat, Double lng) {
        return this.openWeatherApiRepository.getWeather(lat, lng);
    }
}
