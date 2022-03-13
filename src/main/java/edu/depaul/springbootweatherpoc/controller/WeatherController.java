package edu.depaul.springbootweatherpoc.controller;

import edu.depaul.springbootweatherpoc.model.WeatherResult;
import edu.depaul.springbootweatherpoc.service.PrecautionService;
import edu.depaul.springbootweatherpoc.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<WeatherResult> getWeatherDataByCity(
            @PathVariable("city") String city,
            @RequestParam("userName") String userName) {
        try {
            WeatherResult weatherResult = this.weatherService
                    .getWeatherByCityName(city, userName);
            weatherResult.setPrecaution(precautionService.generatePrecaution(weatherResult.getCurrentConditions()));
            return ResponseEntity.ok(weatherResult);
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/zip/{zipCode}")
    public ResponseEntity<WeatherResult> getWeatherDataByZipCode(
            @PathVariable("zipCode") int zipCode,
            @RequestParam("userName") String userName) {
        try {
            WeatherResult weatherResult = this.weatherService
                    .getWeatherByZipCode(zipCode, userName);
            weatherResult.setPrecaution(precautionService.generatePrecaution(weatherResult.getCurrentConditions()));
            return ResponseEntity.ok(weatherResult);
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/coords/{lat}/{lng}")
    public ResponseEntity<WeatherResult> getWeatherDataByCoords(
            @PathVariable("lat") Double lat,
            @PathVariable("lng") Double lng,
            @RequestParam("userName") String userName) {
        try {
            WeatherResult weatherResult = this.weatherService
                    .getWeatherCoords(lat, lng, userName);
            weatherResult.setPrecaution(precautionService.generatePrecaution(weatherResult.getCurrentConditions()));
            return ResponseEntity.ok(weatherResult);
        } catch (Exception exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
