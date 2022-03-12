package edu.depaul.springbootweatherpoc.service;


import edu.depaul.springbootweatherpoc.model.Location;
import edu.depaul.springbootweatherpoc.repository.LocationRepository;
//import edu.depaul.springbootweatherpoc.weather.repository.UserLocationRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserLocationService {
//    private final UserLocationRepository userLocationRepository;
    private final LocationRepository locationRepository;

    public UserLocationService(
//            UserLocationRepository userLocationRepository,
                               LocationRepository locationRepository) {
//        this.userLocationRepository = userLocationRepository;
        this.locationRepository = locationRepository;
    }

    /**
     * Method used to check for and return any locations associated with a username
     * @param userName
     * @return
     */
    public List<edu.depaul.springbootweatherpoc.entity.Location> getUserLocationsByUsername(String userName) {

        //TODO - use userLocationRepository to check for locations associated with the username
        return this.locationRepository.findAllByUserName(userName);
    }

    /**
     * Method used to save a location viewed by a user
     * @param userName
     * @param location
     */
    public void saveUserLocation(String userName, Location location ) {

        //TODO - use userLocationRepository to save location and associate it with the username

        return;
    }

}
