package edu.depaul.springbootweatherpoc.service;

import edu.depaul.springbootweatherpoc.model.Geolocation;
import edu.depaul.springbootweatherpoc.repository.openweather.GeoLocationApiRepository;
import org.springframework.stereotype.Service;

@Service
public class GeoLocationService {
    private final GeoLocationApiRepository geoLocationApiRepository;

    public GeoLocationService(GeoLocationApiRepository geoLocationApiRepository) {
        this.geoLocationApiRepository = geoLocationApiRepository;
    }

    public Geolocation getGeoLocationForCity(String cityName) {
        return this.geoLocationApiRepository.getGeolocationForCity(cityName);
    }

    public Geolocation getGeoLocationForZipCode(int zipCode) {
        return this.geoLocationApiRepository.getGeolocationForZip(zipCode);
    }

    public Geolocation getGeoLocationForCoords(double lat, double lon) {
        return this.geoLocationApiRepository.getGeoLocationForCoords(lat, lon);
    }
}
