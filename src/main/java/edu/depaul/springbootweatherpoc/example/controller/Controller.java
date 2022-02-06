package edu.depaul.springbootweatherpoc.example.controller;

import edu.depaul.springbootweatherpoc.example.constants.Constants;
import edu.depaul.springbootweatherpoc.example.model.DataResponse;
import edu.depaul.springbootweatherpoc.weather.model.TestEntity;
import edu.depaul.springbootweatherpoc.weather.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private TestRepository testRepository;

    @GetMapping("/greetings")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/data")
    public ResponseEntity<DataResponse> getSampleData(){
        List<TestEntity> testEntityList = testRepository.findAll();
        DataResponse response = new DataResponse();
        String data = testEntityList.toString(); //"This is the data. This can be any data type.";
        response.setStatusCode(HttpStatus.OK.value());
        response.setStatusDescription(Constants.SUCCESS_STATUS_MESSAGE);
        response.setData(data);
        return new ResponseEntity<DataResponse>(response, HttpStatus.OK);
    }
}
