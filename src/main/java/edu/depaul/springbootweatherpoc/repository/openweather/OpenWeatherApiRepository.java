package edu.depaul.springbootweatherpoc.repository.openweather;

import edu.depaul.springbootweatherpoc.model.Geolocation;
import edu.depaul.springbootweatherpoc.model.OpenWeatherResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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

    public OpenWeatherResponse getWeather(Geolocation geoLocation) {
        String path = String.format("%s?lat=%s&lon=%s&appid=%s&units=imperial",
                this.openWeatherApiProperties.getApiOneCallBaseUrl(),
                geoLocation.getLatitude(),
                geoLocation.getLongitude(),
                this.openWeatherApiProperties.getApiKey());
        ResponseEntity<String> response = this.restTemplate.getForEntity(path, String.class);
        JSONParser jsonParser = new JSONParser();
        JSONObject responseBody = new JSONObject();
        try {
            responseBody = (JSONObject) jsonParser.parse(response.getBody());
        } catch (Exception e) {
            System.out.println("Failed getting weather data");
        }

        OpenWeatherResponse openWeatherResponse = new OpenWeatherResponse();
        openWeatherResponse.setWeatherData(responseBody);
        openWeatherResponse.setGeolocation(geoLocation);

        return openWeatherResponse;
    }
}
