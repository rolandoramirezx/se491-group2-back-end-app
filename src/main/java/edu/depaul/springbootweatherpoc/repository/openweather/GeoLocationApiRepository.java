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
public class GeoLocationApiRepository {
    private final OpenWeatherApiProperties openWeatherApiProperties;
    private final RestTemplate restTemplate;

    public GeoLocationApiRepository(OpenWeatherApiProperties openWeatherApiProperties) {
        this.openWeatherApiProperties = openWeatherApiProperties;
        this.restTemplate = new RestTemplate();
    }

    public Geolocation getGeolocationForCity(String city) {
        Geolocation res = new Geolocation();

        //call OpenWeather's geolocation API
        String path = String.format("%s/direct?q=%s&limit=5&appid=%s",
                this.openWeatherApiProperties.getApiGeoBaseUrl(),
                city,
                this.openWeatherApiProperties.getApiKey());
        ResponseEntity<String> response = this.restTemplate.getForEntity(path, String.class);

        JSONParser jsonParser = new JSONParser();
        JSONArray responseBody = new JSONArray();
        try {
            responseBody = (JSONArray) jsonParser.parse(response.getBody());
        } catch (Exception e) {
            System.out.println("Failed getting city geolocation");
        }
        JSONObject firstResult = (JSONObject) responseBody.get(0);

        //set latitude and longitude
        res.setLatitude((Double) firstResult.get("lat"));
        res.setLongitude((Double) firstResult.get("lon"));
        res.setCityName((String) firstResult.get("name"));
        return res;
    }

    public Geolocation getGeolocationForZip(int zipCode) {
        Geolocation res = new Geolocation();

        //call OpenWeather's geolocation API
        String path = String.format("%s%s&appid=%s",
                this.openWeatherApiProperties.getApiZipGeoBaseUrl(),
                zipCode,
                this.openWeatherApiProperties.getApiKey());
        ResponseEntity<String> response = this.restTemplate.getForEntity(path, String.class);

        JSONParser jsonParser = new JSONParser();
        JSONObject responseBody = new JSONObject();
        try {
            responseBody = (JSONObject) jsonParser.parse(response.getBody());
        } catch (Exception e) {
            System.out.println("Failed getting zip geolocation");
        }

        //set latitude and longitude
        res.setLatitude((Double) responseBody.get("lat"));
        res.setLongitude((Double) responseBody.get("lon"));
        res.setCityName((String) responseBody.get("name"));
        return res;
    }

    public Geolocation getGeoLocationForCoords(Double lat, Double lng){
        Geolocation res = new Geolocation();

        //call OpenWeather's geolocation API
        String path = String.format("%s?lat=%s&lon=%s&appid=%s",
                this.openWeatherApiProperties.getApiReverseGeoBaseUrl(),
                lat,
                lng,
                this.openWeatherApiProperties.getApiKey());
        ResponseEntity<String> response = this.restTemplate.getForEntity(path, String.class);

        JSONParser jsonParser = new JSONParser();
        JSONArray responseBody = new JSONArray();
        try {
            responseBody = (JSONArray) jsonParser.parse(response.getBody());
        } catch (Exception e) {
            System.out.println("Failed getting reverse geolocation");
        }

        //set latitude and longitude
        JSONObject firstResult = (JSONObject) responseBody.get(0);
        res.setLatitude((Double) firstResult.get("lat"));
        res.setLongitude((Double) firstResult.get("lon"));
        res.setCityName((String) firstResult.get("name"));
        return res;
    }
}
