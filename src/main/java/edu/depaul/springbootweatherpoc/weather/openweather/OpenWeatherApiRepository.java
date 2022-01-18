package edu.depaul.springbootweatherpoc.weather.openweather;

import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class OpenWeatherApiRepository {
    private final OpenWeatherApiProperties openWeatherApiProperties;
    private final RestTemplate restTemplate;

    public OpenWeatherApiRepository(OpenWeatherApiProperties openWeatherApiProperties) {
        this.openWeatherApiProperties = openWeatherApiProperties;
        this.restTemplate = new RestTemplate();
    }

    public JSONObject getWeatherByCity(String city) {
        String path = String.format("%s/weather?q=%s&appid=%s",
                this.openWeatherApiProperties.getApiBaseUrl(),
                city,
                this.openWeatherApiProperties.getApiKey());
        ResponseEntity<JSONObject> response = this.restTemplate.getForEntity(path, JSONObject.class);

        return response.getBody();
    }
}
