package edu.depaul.springbootweatherpoc.weather.controller;

import edu.depaul.springbootweatherpoc.weather.model.Location;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.depaul.springbootweatherpoc.service.LocationService;

@RestController
@RequestMapping("weather")
public class LocationController {
    private final LocationService locationService;

    public LocationController (LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/userName/{userName}")
    public void saveLocation(@PathVariable("userName") String userName, @PathVariable("location") Location location ) {
        return ;
    }

}
