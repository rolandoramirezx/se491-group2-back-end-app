package edu.depaul.springbootweatherpoc.weather.controller;

import edu.depaul.springbootweatherpoc.weather.model.Location;
import org.springframework.web.bind.annotation.*;
import edu.depaul.springbootweatherpoc.service.UserLocationService;

import java.util.List;

@RestController
@RequestMapping("location")
public class LocationController {
    private final UserLocationService userLocationService;

    public LocationController (UserLocationService userLocationService) {
        this.userLocationService = userLocationService;
    }

    /**
     * Endpoint used to save a location viewed by a user
     * @param userName
     * @param location
     */
    @PostMapping("/user/{userName}")
    public void saveLocation(@PathVariable("userName") String userName, @RequestBody Location location) {

        //TODO - use service to save location and username, which will allows us to get locations for this user in the future

        return;
    }

    /**
     * Endpoint used to check for and return any locations associated with a username
     * @param userName
     */
    @GetMapping("/user/{userName}")
    public List<Location> getLocationsByUserName(@PathVariable("userName") String userName) {

        //TODO - use service to check for any locations associated with the username and return them if any are found

        return null;
    }

}
