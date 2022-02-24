package edu.depaul.springbootweatherpoc.service;

import edu.depaul.springbootweatherpoc.util.WeatherUtil;
import edu.depaul.springbootweatherpoc.weather.model.OpenWeatherResponse;
import edu.depaul.springbootweatherpoc.weather.model.WeatherResult;
import edu.depaul.springbootweatherpoc.weather.openweather.OpenWeatherApiRepository;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    private final OpenWeatherApiRepository openWeatherApiRepository;
    private final WeatherUtil weatherUtil = new WeatherUtil();

    public WeatherService(OpenWeatherApiRepository openWeatherApiRepository) {
        this.openWeatherApiRepository = openWeatherApiRepository;
    }

    public WeatherResult getWeather(String city) {
        OpenWeatherResponse openWeatherResponse = this.openWeatherApiRepository.getWeather(city);
        return weatherUtil.processOpenWeatherResponse(openWeatherResponse);
    }

    public WeatherResult getWeather(int zipCode) {
        OpenWeatherResponse openWeatherResponse = this.openWeatherApiRepository.getWeather(zipCode);
        return weatherUtil.processOpenWeatherResponse(openWeatherResponse);
    }

    public WeatherResult getWeather(Double lat, Double lng) {
        OpenWeatherResponse openWeatherResponse = this.openWeatherApiRepository.getWeather(lat, lng);
        return weatherUtil.processOpenWeatherResponse(openWeatherResponse);
    }
}
