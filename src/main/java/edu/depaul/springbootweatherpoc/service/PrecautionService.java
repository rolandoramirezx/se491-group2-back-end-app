package edu.depaul.springbootweatherpoc.service;

import edu.depaul.springbootweatherpoc.model.Precaution;
import edu.depaul.springbootweatherpoc.model.Weather;
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
            precaution.setMessage("stay inside a sturdy building or shelter");
        } else if (currentConditions.getWeatherDescription().toLowerCase().contains("drizzle")){
            precaution.setMessage("wear a light rain jacket");
        } else if (currentConditions.getWeatherDescription().toLowerCase().contains("rain")){
            precaution.setMessage("bring an umbrella");
        } else if (currentConditions.getWeatherDescription().toLowerCase().contains("snow")){
            precaution.setMessage("dress properly for a cold weather");
        } else if (currentConditions.getWeatherDescription().toLowerCase().contains("mist")){
            precaution.setMessage("caution is required due to the lack of visibility");
        } else if (currentConditions.getWeatherDescription().toLowerCase().contains("smoke")){
            precaution.setMessage("caution is required due to the lack of visibility");
        } else if (currentConditions.getWeatherDescription().toLowerCase().contains("haze")){
            precaution.setMessage("caution is required due to the lack of visibility");
        } else if (currentConditions.getWeatherDescription().toLowerCase().contains("dust")){
            precaution.setMessage("wear a mask and watch your steps");
        } else if (currentConditions.getWeatherDescription().toLowerCase().contains("ash")){
            precaution.setMessage("wear a mask and watch your steps");
        } else if (currentConditions.getWeatherDescription().toLowerCase().contains("squall")){
            precaution.setMessage("stay inside a sturdy building or shelter");
        } else if (currentConditions.getWeatherDescription().toLowerCase().contains("tornado")){
            precaution.setMessage("stay inside a sturdy building or shelter");
        } else if (currentConditions.getWeatherDescription().toLowerCase().contains("clear")){
            precaution.setMessage("the weather is good for going out");
        } else if (currentConditions.getWeatherDescription().toLowerCase().contains("cloud")){
            precaution.setMessage("bring an umbrella");
        } else{
            precaution.setMessage("this is a precaution");
        }
        return precaution;
    }
}
