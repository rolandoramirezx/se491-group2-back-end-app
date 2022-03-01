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

        if(currentConditions.getWeatherDescription().toLowerCase().contains("thunderstorm")){
            precaution.setPrecaution("stay inside a sturdy building or shelter");
        } else if (currentConditions.getWeatherDescription().toLowerCase().contains("drizzle")){
            precaution.setPrecaution("wear a light rain jacket");
        } else if (currentConditions.getWeatherDescription().toLowerCase().contains("rain")){
            precaution.setPrecaution("bring an umbrella");
        } else if (currentConditions.getWeatherDescription().toLowerCase().contains("snow")){
            precaution.setPrecaution("dress properly for a cold weather");
        } else if (currentConditions.getWeatherDescription().toLowerCase().contains("mist")){
            precaution.setPrecaution("caution is required due to the lack of visibility");
        } else if (currentConditions.getWeatherDescription().toLowerCase().contains("smoke")){
            precaution.setPrecaution("caution is required due to the lack of visibility");
        } else if (currentConditions.getWeatherDescription().toLowerCase().contains("haze")){
            precaution.setPrecaution("caution is required due to the lack of visibility");
        } else if (currentConditions.getWeatherDescription().toLowerCase().contains("dust")){
            precaution.setPrecaution("wear a mask and watch your steps");
        } else if (currentConditions.getWeatherDescription().toLowerCase().contains("ash")){
            precaution.setPrecaution("wear a mask and watch your steps");
        } else if (currentConditions.getWeatherDescription().toLowerCase().contains("squall")){
            precaution.setPrecaution("stay inside a sturdy building or shelter");
        } else if (currentConditions.getWeatherDescription().toLowerCase().contains("tornado")){
            precaution.setPrecaution("stay inside a sturdy building or shelter");
        } else if (currentConditions.getWeatherDescription().toLowerCase().contains("clear")){
            precaution.setPrecaution("the weather is good for going out");
        } else if (currentConditions.getWeatherDescription().toLowerCase().contains("cloud")){
            precaution.setPrecaution("bring an umbrella");
        } else{
            precaution.setPrecaution("this is a precaution");
        }
        return precaution;
    }
}
