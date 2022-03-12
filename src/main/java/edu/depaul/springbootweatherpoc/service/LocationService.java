package edu.depaul.springbootweatherpoc.service;
import edu.depaul.springbootweatherpoc.entity.Location;
import edu.depaul.springbootweatherpoc.repository.LocationRepository;
import edu.depaul.springbootweatherpoc.util.StreamUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Transactional
@Service
public class LocationService {
    private static final int MAX_RECENTLY_VIEWED_LOCATIONS = 5;

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    /**
     * Method used to check for and return any locations associated with a username
     * @param userName the username of the user to get locations for
     * @return a list of locations sorted by date create desc
     */
    public List<Location> getUserLocationsByUsername(String userName) {
        return this.locationRepository
                .findAllByUserName(userName)
                .stream()
                .sorted(Comparator.comparing(Location::getDateCreated).reversed())
                .collect(Collectors.toList());
    }

    /**
     * Method used to update list of recently viewed locations for a user
     * Limits the number of locations stored and deletes any that go over the limit
     * @param location New Recently viewed location
     */
    public void addRecentlyViewedLocation(Location location) {
        location.setDateCreated(Instant.now());
        locationRepository.saveAndFlush(location);

        List<Location> viewedLocations = locationRepository.findAllByUserName(location.getUserName());
        viewedLocations.add(location);

        List<Location> updatedLocations = viewedLocations.stream()
                        .sorted(Comparator.comparing(Location::getDateCreated).reversed())
                        .filter(StreamUtils.distinctByKey(Location::getCityName))
                        .limit(MAX_RECENTLY_VIEWED_LOCATIONS)
                        .collect(Collectors.toList());

        List<Location> locationsToRemove = new ArrayList<>(viewedLocations);
        locationsToRemove.removeAll(updatedLocations);

        this.locationRepository.deleteAll(locationsToRemove);
    }
}
