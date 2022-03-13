package edu.depaul.springbootweatherpoc.util;

import edu.depaul.springbootweatherpoc.entity.Location;
import edu.depaul.springbootweatherpoc.model.Geolocation;

public class LocationUtils {
    public static Location fromGeoLocation(Geolocation geolocation) {
        return Location.builder()
                .cityName(geolocation.getCityName())
                .latitude(geolocation.getLatitude())
                .longitude(geolocation.getLongitude())
                .build();
    }
}
