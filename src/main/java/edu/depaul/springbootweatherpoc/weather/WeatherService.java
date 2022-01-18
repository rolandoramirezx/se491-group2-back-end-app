package edu.depaul.springbootweatherpoc.weather;

import edu.depaul.springbootweatherpoc.weather.openweather.OpenWeatherApiRepository;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    private final OpenWeatherApiRepository openWeatherApiRepository;

    public WeatherService(OpenWeatherApiRepository openWeatherApiRepository) {
        this.openWeatherApiRepository = openWeatherApiRepository;
    }

    public JSONObject getWeatherByCity(String city) {
        return this.openWeatherApiRepository.getWeatherByCity(city);
    }
}
