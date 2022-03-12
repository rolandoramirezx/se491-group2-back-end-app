package edu.depaul.springbootweatherpoc.service;


import edu.depaul.springbootweatherpoc.weather.model.Location;
import edu.depaul.springbootweatherpoc.weather.repository.UserLocationRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Service
public class UserLocationService {
    private final UserLocationRepository userLocationRepository;

    public UserLocationService(UserLocationRepository userLocationRepository) {
        this.userLocationRepository = userLocationRepository;
    }

    /**
     * Method used to check for and return any locations associated with a username
     * @param userName
     * @return
     */
    public List<Location> getUserLocation(String userName) {

        //TODO - use userLocationRepository to check for locations associated with the username

        return null;
    }

    /**
     * Method used to save a location viewed by a user
     * @param userName
     * @param location
     */
    public void saveLocation(@PathVariable("userName") String userName, @PathVariable("location") Location location ) {

        //TODO - use userLocationRepository to save location and associate it with the username

        return;
    }

}