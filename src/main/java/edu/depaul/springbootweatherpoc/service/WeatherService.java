package edu.depaul.springbootweatherpoc.service;

import edu.depaul.springbootweatherpoc.entity.Location;
import edu.depaul.springbootweatherpoc.model.Alert;
import edu.depaul.springbootweatherpoc.model.Geolocation;
import edu.depaul.springbootweatherpoc.util.LocationUtils;
import edu.depaul.springbootweatherpoc.util.WeatherUtil;
import edu.depaul.springbootweatherpoc.model.OpenWeatherResponse;
import edu.depaul.springbootweatherpoc.model.WeatherResult;
import edu.depaul.springbootweatherpoc.repository.openweather.OpenWeatherApiRepository;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class WeatherService {
    private final static String FAKE_ALERT_CITY = "Miami";

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
        WeatherResult weatherResult = this.convertToWeatherResult(openWeatherResponse);

        this.recordLocation(geolocation, userName);

        return weatherResult;
    }

    private void recordLocation(Geolocation geolocation, String userName) {
        Location newLocation = LocationUtils.fromGeoLocation(geolocation);
        newLocation.setUserName(userName);
        this.locationService.addRecentlyViewedLocation(newLocation);
    }


    private WeatherResult convertToWeatherResult(OpenWeatherResponse openWeatherResponse){
        WeatherResult weatherResult = weatherUtil.processOpenWeatherResponse(openWeatherResponse);

        // NOTE This method exists in order to demo an alert if the city is Miami
        if (openWeatherResponse.getGeolocation().getCityName().equalsIgnoreCase(FAKE_ALERT_CITY)) {
            Alert fakeAlert = Alert.builder()
                    .title("[Fake Alert]: Hurricane Nearby")
                    .message("Evacuate the area, there is a hurricane nearby")
                    .build();
            weatherResult.setAlert(fakeAlert);
        }

        return weatherResult;
    }
}
