package edu.depaul.springbootweatherpoc.controller;
import edu.depaul.springbootweatherpoc.entity.Location;
import org.springframework.web.bind.annotation.*;
import edu.depaul.springbootweatherpoc.service.LocationService;

import java.util.List;

@RestController
@RequestMapping("location")
public class LocationController {
    private final LocationService locationService;

    public LocationController (LocationService locationService) {
        this.locationService = locationService;
    }

    /**
     * Endpoint used to check for and return any locations associated with a username
     * @param userName the user name to get locations for
     * @return a list of recently viewed locations by user
     */
    @GetMapping
    public List<Location> getLocationsByUserName(
            @RequestParam(value = "userName") String userName) {
        return this.locationService.getUserLocationsByUsername(userName);
    }

}
