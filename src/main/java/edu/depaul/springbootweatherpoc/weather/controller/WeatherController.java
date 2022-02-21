package edu.depaul.springbootweatherpoc.weather.controller;

import edu.depaul.springbootweatherpoc.weather.WeatherService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weather")
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/city/{city}")
    public JSONObject getWeatherDataByCity(@PathVariable("city") String city) {
        return this.weatherService.getWeather(city);
    }

    @GetMapping("/zip/{zipCode}")
    public JSONObject getWeatherDataByCity(@PathVariable("zipCode") int zipCode) {
        return this.weatherService.getWeather(zipCode);
    }

    @GetMapping("/current-location/{lat}/{lng}")
    public JSONObject getWeatherDataByCity(@PathVariable("lat") float lat, @PathVariable("lat") float lng) {
        return this.weatherService.getWeather(lat, lng);
    }

}
