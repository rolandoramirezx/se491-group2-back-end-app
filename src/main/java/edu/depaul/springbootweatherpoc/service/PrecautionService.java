package edu.depaul.springbootweatherpoc.service;

import edu.depaul.springbootweatherpoc.weather.model.Precaution;
import edu.depaul.springbootweatherpoc.weather.model.Weather;
import org.springframework.stereotype.Service;

@Service
public class PrecautionService {

    public PrecautionService(){

    }

    /**
     * Method to generate a precaution based on the current weather conditions provided from the OpenWeather API
     * @param currentConditions the current conditions provided from the OpenWeather API, which was converted into a simplified Weather object
     * @return
     */
    public Precaution generatePrecaution(Weather currentConditions){

        Precaution precaution = new Precaution();

        //this is an example of the logic we're looking for
        //you can just check for any "main" descriptions, more details at https://openweathermap.org/weather-conditions#Weather-Condition-Codes-2
        if(currentConditions.getDescription().contains("thunderstorm")){
            precaution.setPrecaution("bring an umbrella");
        } else if (currentConditions.getDescription().contains("drizzle")){
            precaution.setPrecaution("wear a light rain jacket");
        } else{
            precaution.setPrecaution("this is a precaution");
        }

        return precaution;
    }
}
