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

        if(currentConditions.getDescription().contains("thunderstorm")){
            precaution.setPrecaution("stay inside a sturdy building or shelter");
        } else if (currentConditions.getDescription().contains("drizzle")){
            precaution.setPrecaution("wear a light rain jacket");
        } else if (currentConditions.getDescription().contains("rain")){
            precaution.setPrecaution("bring an umbrella");
        } else if (currentConditions.getDescription().contains("snow")){
            precaution.setPrecaution("dress properly for a cold weather");
        } else if (currentConditions.getDescription().contains("mist")){
            precaution.setPrecaution("caution is required due to the lack of visibility");
        } else if (currentConditions.getDescription().contains("smoke")){
            precaution.setPrecaution("caution is required due to the lack of visibility");
        } else if (currentConditions.getDescription().contains("haze")){
            precaution.setPrecaution("caution is required due to the lack of visibility");
        } else if (currentConditions.getDescription().contains("dust")){
            precaution.setPrecaution("wear a mask and watch your steps");
        } else if (currentConditions.getDescription().contains("ash")){
            precaution.setPrecaution("wear a mask and watch your steps");
        } else if (currentConditions.getDescription().contains("squall")){
            precaution.setPrecaution("stay inside a sturdy building or shelter");
        } else if (currentConditions.getDescription().contains("tornado")){
            precaution.setPrecaution("stay inside a sturdy building or shelter");
        } else if (currentConditions.getDescription().contains("clear")){
            precaution.setPrecaution("the weather is good for going out");
        } else if (currentConditions.getDescription().contains("could")){
            precaution.setPrecaution("bring an umbrella");
        } else{
            precaution.setPrecaution("this is a precaution");
        }
        return precaution;
    }
}
