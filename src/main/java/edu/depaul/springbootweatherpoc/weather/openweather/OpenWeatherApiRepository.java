package edu.depaul.springbootweatherpoc.weather.openweather;

import edu.depaul.springbootweatherpoc.weather.model.Geolocation;
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

    private Geolocation getGeolocationForCity(String city){
        Geolocation res = new Geolocation();

        //call OpenWeather's geolocation API
        String path = String.format("%s/direct?q=%s&limit=5&appid=%s",
                this.openWeatherApiProperties.getApiGeoBaseUrl(),
                city,
                this.openWeatherApiProperties.getApiKey());
        ResponseEntity<String> response = this.restTemplate.getForEntity(path, String.class);

        JSONParser jsonParser = new JSONParser();
        JSONArray responseBody = new JSONArray();
        try{
            responseBody = (JSONArray) jsonParser.parse(response.getBody());
        } catch (Exception e){
            System.out.println("Failed getting city geolocation");
        }
        JSONObject firstResult = (JSONObject) responseBody.get(0);

        //set latitude and longitude
        res.setLatitude((Double) firstResult.get("lat"));
        res.setLongitude((Double) firstResult.get("lon"));
        return res;
    }

    private Geolocation getGeolocationForZip(int zipCode){
        Geolocation res = new Geolocation();

        //call OpenWeather's geolocation API
        String path = String.format("%s%s&appid=%s",
                this.openWeatherApiProperties.getApiZipGeoBaseUrl(),
                zipCode,
                this.openWeatherApiProperties.getApiKey());
        ResponseEntity<String> response = this.restTemplate.getForEntity(path, String.class);

        JSONParser jsonParser = new JSONParser();
        JSONObject responseBody = new JSONObject();
        try{
            responseBody = (JSONObject) jsonParser.parse(response.getBody());
        } catch (Exception e){
            System.out.println("Failed getting city geolocation");
        }

        //set latitude and longitude
        res.setLatitude((Double) responseBody.get("lat"));
        res.setLongitude((Double) responseBody.get("lon"));
        return res;
    }

    public JSONObject getWeather(String city) {

        Geolocation geo = getGeolocationForCity(city);

        String path = String.format("%s?lat=%s&lon=%s&appid=%s",
                this.openWeatherApiProperties.getApiOneCallBaseUrl(),
                geo.getLatitude(),
                geo.getLongitude(),
                this.openWeatherApiProperties.getApiKey());
        ResponseEntity<String> response = this.restTemplate.getForEntity(path, String.class);
        JSONParser jsonParser = new JSONParser();
        JSONObject responseBody = new JSONObject();
        try{
            responseBody = (JSONObject) jsonParser.parse(response.getBody());
        } catch (Exception e){
            System.out.println("Failed getting city geolocation");
        }

        return responseBody;
    }

    public JSONObject getWeather(int Zipcode) {

        Geolocation geo = getGeolocationForZip(Zipcode);

        String path = String.format("%s?lat=%s&lon=%s&appid=%s",
                this.openWeatherApiProperties.getApiOneCallBaseUrl(),
                geo.getLongitude(),
                geo.getLongitude(),
                this.openWeatherApiProperties.getApiKey());
        ResponseEntity<JSONObject> response = this.restTemplate.getForEntity(path, JSONObject.class);

        return response.getBody();
    }

    public JSONObject getWeather(float lat, float lng) {
        String path = String.format("%s?lat=%s&lon=%s&appid=%s",
                this.openWeatherApiProperties.getApiOneCallBaseUrl(),
                lat,
                lng,
                this.openWeatherApiProperties.getApiKey());
        ResponseEntity<JSONObject> response = this.restTemplate.getForEntity(path, JSONObject.class);

        return response.getBody();
    }
}
