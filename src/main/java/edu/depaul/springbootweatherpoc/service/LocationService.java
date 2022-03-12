package edu.depaul.springbootweatherpoc.service;


import edu.depaul.springbootweatherpoc.weather.model.Location;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getUserLocation(String userName) {
        return null;
    }
    public void saveLocation(@PathVariable("userName") String userName, @PathVariable("location") Location location ) {
        return ;    }

}
