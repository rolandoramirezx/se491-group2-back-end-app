package edu.depaul.springbootweatherpoc.controller;

import edu.depaul.springbootweatherpoc.service.PrecautionService;
import edu.depaul.springbootweatherpoc.service.WeatherService;
import edu.depaul.springbootweatherpoc.model.WeatherResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weather")
public class WeatherController {
    private final WeatherService weatherService;
    private final PrecautionService precautionService;

    public WeatherController(WeatherService weatherService, PrecautionService precautionService) {
        this.weatherService = weatherService;
        this.precautionService = precautionService;
    }

    @GetMapping("/city/{city}")
    public WeatherResult getWeatherDataByCity(@PathVariable("city") String city) {
        WeatherResult weatherResult = this.weatherService.getWeather(city);
        weatherResult.setPrecaution(precautionService.generatePrecaution(weatherResult.getCurrentConditions()));
        return weatherResult;
    }

    @GetMapping("/zip/{zipCode}")
    public WeatherResult getWeatherDataByCity(@PathVariable("zipCode") int zipCode) {
        WeatherResult weatherResult = this.weatherService.getWeather(zipCode);
        weatherResult.setPrecaution(precautionService.generatePrecaution(weatherResult.getCurrentConditions()));
        return weatherResult;
    }

    @GetMapping("/current-location/{lat}/{lng}")
    public WeatherResult getWeatherDataByCity(@PathVariable("lat") Double lat, @PathVariable("lat") Double lng) {
        WeatherResult weatherResult = this.weatherService.getWeather(lat, lng);
        weatherResult.setPrecaution(precautionService.generatePrecaution(weatherResult.getCurrentConditions()));
        return weatherResult;
    }

}
