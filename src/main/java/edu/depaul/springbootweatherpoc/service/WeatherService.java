package edu.depaul.springbootweatherpoc.service;

import edu.depaul.springbootweatherpoc.entity.Location;
import edu.depaul.springbootweatherpoc.model.Geolocation;
import edu.depaul.springbootweatherpoc.util.LocationUtils;
import edu.depaul.springbootweatherpoc.util.WeatherUtil;
import edu.depaul.springbootweatherpoc.model.OpenWeatherResponse;
import edu.depaul.springbootweatherpoc.model.WeatherResult;
import edu.depaul.springbootweatherpoc.repository.openweather.OpenWeatherApiRepository;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    private final GeoLocationService geoLocationService;
    private final LocationService locationService;
    private final OpenWeatherApiRepository openWeatherApiRepository;
    private final WeatherUtil weatherUtil = new WeatherUtil();

    public WeatherService(GeoLocationService geoLocationService,
                          LocationService locationService,
                          OpenWeatherApiRepository openWeatherApiRepository) {
        this.geoLocationService = geoLocationService;
        this.locationService = locationService;
        this.openWeatherApiRepository = openWeatherApiRepository;
    }

    public WeatherResult getWeatherByCityName(String cityName, String userName) {
        Geolocation geolocation = this.geoLocationService.getGeoLocationForCity(cityName);
        return this.getWeather(geolocation, userName);
    }

    public WeatherResult getWeatherByZipCode(int zipCode, String userName) {
        Geolocation geolocation = this.geoLocationService.getGeoLocationForZipCode(zipCode);
        return this.getWeather(geolocation, userName);
    }

    public WeatherResult getWeatherCoords(Double lat, Double lng, String userName) {
        Geolocation geolocation = this.geoLocationService.getGeoLocationForCoords(lat, lng);
        return this.getWeather(geolocation, userName);
    }

    private WeatherResult getWeather(Geolocation geolocation, String userName) {
        OpenWeatherResponse openWeatherResponse = this.openWeatherApiRepository.getWeather(geolocation);
        WeatherResult weatherResult = weatherUtil.processOpenWeatherResponse(openWeatherResponse);

        this.recordLocation(geolocation, userName);

        return weatherResult;
    }

    private void recordLocation(Geolocation geolocation, String userName) {
        Location newLocation = LocationUtils.fromGeoLocation(geolocation);
        newLocation.setUserName(userName);
        this.locationService.addRecentlyViewedLocation(newLocation);
    }
}
