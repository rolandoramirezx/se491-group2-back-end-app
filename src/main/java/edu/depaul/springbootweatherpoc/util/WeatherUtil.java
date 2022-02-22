package edu.depaul.springbootweatherpoc.util;

import edu.depaul.springbootweatherpoc.weather.model.DayForecast;
import edu.depaul.springbootweatherpoc.weather.model.HourlyForecast;
import edu.depaul.springbootweatherpoc.weather.model.Weather;
import edu.depaul.springbootweatherpoc.weather.model.WeatherResult;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Date;

public class WeatherUtil {

    public WeatherUtil (){}

    /**
     * Method used to filter OpenWeather API response and create a WeatherResult option
     * @param response - the response from the OpenWeather API
     * @return
     */
    public WeatherResult processOpenWeatherResponse(JSONObject response){

        WeatherResult res = new WeatherResult();

        JSONObject current = (JSONObject) response.get("current");
        JSONArray description = (JSONArray) current.get("weather");
        JSONArray hourly = (JSONArray) response.get("hourly");
        JSONArray daily = (JSONArray) response.get("daily");

        res.setCurrentConditions(getWeather(current,description));
        res.setHourlyForecast(getHourlyForecast(hourly));
        res.setDayForecasts(getDailyForecast(daily));
        res.setTomorrowForecast(getTomorrowForecast(daily));
        res.setDate(new Date());

        return res;
    }

    /**
     * Method used to filter OpenWeather's current weather details and create a Weather object
     * @param current - the current weather data the OpenWeather API
     * @param description - the current weather description array from the OpenWeather API
     * @return
     */
    private Weather getWeather(JSONObject current, JSONArray description){

        JSONObject weather = (JSONObject) description.get(0);

        Weather res = new Weather();
        res.setTemp((Double) current.get("temp"));
        res.setWindSpeed((Double)current.get("wind_speed"));
        res.setClouds((Long)current.get("clouds"));
        res.setHumidity((Long)current.get("humidity"));
        res.setDescription((String) weather.get("description"));

        return res;
    }

    /**
     * Method used to filter OpenWeather's hourly weather details and create an HourlyForecast array
     * @param hourly - the hourly weather data array from the OpenWeather API
     * @return
     */
    private HourlyForecast[] getHourlyForecast(JSONArray hourly){

        ArrayList<HourlyForecast> list = new ArrayList<>();

        for(Object forecast: hourly){
            HourlyForecast hourlyForecast = new HourlyForecast();
            Weather weather = new Weather();

            JSONObject jsonObject = (JSONObject)  forecast;
            Long timestamp = (Long) jsonObject.get("dt");
            java.util.Date time=new java.util.Date(timestamp*1000);
            hourlyForecast.setDate(time);

            weather.setClouds((Long)jsonObject.get("clouds"));
            try{
                //the OpenWeather API does not always put temperature in a double format, so we need to adjust our logic as needed
                weather.setTemp((Double) jsonObject.get("temp"));
            } catch (Exception e){
                //when the temperature is not in a double format, we know it's in a long format, so we can use that value and convert it to a double
                System.out.println("unable to convert temp to double");
                Long temp = (Long) jsonObject.get("temp");
                weather.setTemp(temp.doubleValue());
            }
            weather.setWindSpeed((Double) jsonObject.get("wind_speed"));
            weather.setHumidity((Long) jsonObject.get("humidity"));
            JSONArray currentWeather = (JSONArray) jsonObject.get("weather");
            JSONObject description = (JSONObject) currentWeather.get(0);
            weather.setDescription((String) description.get("description"));
            hourlyForecast.setWeather(weather);

            list.add(hourlyForecast);

        }

        return (list.toArray(new HourlyForecast[list.size()]));
    }

    /**
     * Method used to filter OpenWeather's daily weather details and create a DailyForecast array
     * @param daily - the daily weather data array from the OpenWeather API
     * @return
     */
    private DayForecast[] getDailyForecast(JSONArray daily){

        ArrayList<DayForecast> list = new ArrayList<>();

        for(Object forecast: daily){
            DayForecast dayForecast = new DayForecast();
            Weather weather = new Weather();

            JSONObject jsonObject = (JSONObject)  forecast;
            Long timestamp = (Long) jsonObject.get("dt");
            java.util.Date time=new java.util.Date(timestamp*1000);
            dayForecast.setDate(time);

            weather.setClouds((Long)jsonObject.get("clouds"));
            try{
                //the OpenWeather API stores daily temperature in its own object (instead of single value)
                // so, we need to choose which temperature to use in our Weather object
                JSONObject temp = ((JSONObject) jsonObject.get("temp"));
                Double dayTemperature = (Double)temp.get("day");
                weather.setTemp(dayTemperature);
            } catch (Exception e){
                System.out.println("unable to convert temp to double");
            }
            weather.setWindSpeed((Double) jsonObject.get("wind_speed"));
            weather.setHumidity((Long) jsonObject.get("humidity"));
            JSONArray currentWeather = (JSONArray) jsonObject.get("weather");
            JSONObject description = (JSONObject) currentWeather.get(0);
            weather.setDescription((String) description.get("description"));
            dayForecast.setWeather(weather);

            list.add(dayForecast);

        }

        return (list.toArray(new DayForecast[list.size()]));
    }

    /**
     * Method used to read OpenWeather's daily forecast array and create a DailyForecast object for tomorrow's forecast
     * @param daily - the daily weather data array from the OpenWeather API
     * @return
     */
    private DayForecast getTomorrowForecast(JSONArray daily) {

        ArrayList<DayForecast> list = new ArrayList<>();

        //we start by getting the second forecast in the array, as that is tomorrow's forecast
        JSONObject forecast = (JSONObject) daily.get(1);

        DayForecast dayForecast = new DayForecast();
        Weather weather = new Weather();

        Long timestamp = (Long) forecast.get("dt");
        java.util.Date time = new java.util.Date(timestamp * 1000);
        dayForecast.setDate(time);

        weather.setClouds((Long) forecast.get("clouds"));
        try {
            //the OpenWeather API stores daily temperature in its own object (instead of single value)
            // so, we need to choose which temperature to use in our Weather object
            JSONObject temp = ((JSONObject) forecast.get("temp"));
            Double dayTemperature = (Double) temp.get("day");
            weather.setTemp(dayTemperature);
        } catch (Exception e) {
            System.out.println("unable to convert temp to double");
        }
        weather.setWindSpeed((Double) forecast.get("wind_speed"));
        weather.setHumidity((Long) forecast.get("humidity"));
        JSONArray currentWeather = (JSONArray) forecast.get("weather");
        JSONObject description = (JSONObject) currentWeather.get(0);
        weather.setDescription((String) description.get("description"));
        dayForecast.setWeather(weather);

        return dayForecast;
    }

}
