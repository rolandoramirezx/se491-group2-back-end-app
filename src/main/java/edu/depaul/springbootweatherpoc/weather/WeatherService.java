package edu.depaul.springbootweatherpoc.weather;

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

    public JSONObject getWeather(String city) {
        return this.openWeatherApiRepository.getWeather(city);
    }

    public JSONObject getWeather(int zipCode) {
        return this.openWeatherApiRepository.getWeather(zipCode);
    }

    public JSONObject getWeather(float lat, float lng) {
        return this.openWeatherApiRepository.getWeather(lat, lng);
    }
}
