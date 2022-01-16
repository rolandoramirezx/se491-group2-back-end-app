package edu.depaul.springbootweatherpoc.engine;

import edu.depaul.springbootweatherpoc.constants.Constants;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

public class WeatherEngine {

    public static JSONObject getWeatherDataByCity(String city) throws ParseException {

        String URL = Constants.CITY_DATA_ENDPOINT + city + Constants.API_KEY;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);

        JSONParser jsonParser = new JSONParser();
        JSONObject weatherData = (JSONObject) jsonParser.parse(response.getBody());

        return weatherData;

    }
}
