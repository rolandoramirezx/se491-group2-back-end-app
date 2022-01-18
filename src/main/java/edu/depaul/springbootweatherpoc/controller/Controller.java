package edu.depaul.springbootweatherpoc.controller;

import  edu.depaul.springbootweatherpoc.constants.Constants;
import edu.depaul.springbootweatherpoc.engine.WeatherEngine;
import edu.depaul.springbootweatherpoc.model.DataResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/greetings")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/data")
    public ResponseEntity<DataResponse> getSampleData(){
        DataResponse response = new DataResponse();
        String data = "This is the data. This can be any data type.";
        response.setStatusCode(HttpStatus.OK.value());
        response.setStatusDescription(Constants.SUCCESS_STATUS_MESSAGE);
        response.setData(data);
        return new ResponseEntity<DataResponse>(response, HttpStatus.OK);
    }

    @GetMapping("/weather/{city}")
    public JSONObject getWeatherDataByCity(@PathVariable("city") String city) throws ParseException {
        return WeatherEngine.getWeatherDataByCity(city);
    }

}
