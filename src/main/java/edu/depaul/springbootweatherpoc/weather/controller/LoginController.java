package edu.depaul.springbootweatherpoc.weather.controller;

import edu.depaul.springbootweatherpoc.service.WeatherService;
import edu.depaul.springbootweatherpoc.weather.model.Location;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("weather")
public class LoginController {
    private final WeatherService weatherService;

    public LoginController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/userName/{userName}")
    public List<Location> getUserLocation(@PathVariable("userName") String userName) {
        return null;
    }

}
