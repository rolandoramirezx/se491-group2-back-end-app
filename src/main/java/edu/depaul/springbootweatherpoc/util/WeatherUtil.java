package edu.depaul.springbootweatherpoc.util;

import edu.depaul.springbootweatherpoc.model.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Date;

public class WeatherUtil {

    public WeatherUtil() {
    }

    /**
     * Method used to filter OpenWeather API response and create a WeatherResult option
     *
     * @param openWeatherResponse the response from the OpenWeather API
     * @return
     */
    public WeatherResult processOpenWeatherResponse(OpenWeatherResponse openWeatherResponse) {

        WeatherResult res = new WeatherResult();
        JSONObject weatherData = openWeatherResponse.getWeatherData();

        JSONObject current = (JSONObject) weatherData.get("current");
        JSONArray description = (JSONArray) current.get("weather");
        JSONArray hourly = (JSONArray) weatherData.get("hourly");
        JSONArray daily = (JSONArray) weatherData.get("daily");
        JSONArray alerts = (JSONArray) weatherData.get("alerts");

        res.setCurrentConditions(getWeather(current, description));
        res.setHourlyForecast(getHourlyForecast(hourly));
        res.setDayForecasts(getDailyForecast(daily));
        res.setTomorrowForecast(getTomorrowForecast(daily));
        res.setCurrentLocation(getLocation(openWeatherResponse.getGeolocation()));
        res.setGeneratedTimestamp(new Date());
        res.setAlert(getAlert(alerts));

        return res;
    }

    /**
     * Method used to filter OpenWeather's current weather details and create a Weather object
     *
     * @param current     the current weather data the OpenWeather API
     * @param description the current weather description array from the OpenWeather API
     * @return
     */
    private Weather getWeather(JSONObject current, JSONArray description) {

        JSONObject weather = (JSONObject) description.get(0);

        Weather res = new Weather();

        String mainDescription = getMainDescription((weather.get("description").toString()));

        res.setTemp(Double.parseDouble(current.get("temp").toString()));
        res.setWindSpeed(Double.parseDouble("100"));
        res.setClouds(Long.parseLong(current.get("clouds").toString()));
        res.setHumidity(Long.parseLong(current.get("humidity").toString()));
        res.setWeatherDescription(mainDescription);

        return res;
    }

    /**
     * Method used to filter OpenWeather's hourly weather details and create an HourlyForecast array
     *
     * @param hourly the hourly weather data array from the OpenWeather API
     * @return
     */
    private HourlyForecast[] getHourlyForecast(JSONArray hourly) {

        ArrayList<HourlyForecast> list = new ArrayList<>();

        for (Object forecast : hourly) {
            HourlyForecast hourlyForecast = new HourlyForecast();
            Weather weather = new Weather();

            JSONObject jsonObject = (JSONObject) forecast;
            Long timestamp = Long.parseLong(jsonObject.get("dt").toString());
            java.util.Date time = new java.util.Date(timestamp * 1000);
            hourlyForecast.setDate(time);
            hourlyForecast.setDay(getDay(time.getDay()));
            hourlyForecast.setHour(time.getHours());

            weather.setClouds(Long.parseLong(jsonObject.get("clouds").toString()));
            weather.setTemp(Double.parseDouble(jsonObject.get("temp").toString()));
            weather.setWindSpeed(Double.parseDouble(jsonObject.get("wind_speed").toString()));
            weather.setHumidity(Long.parseLong(jsonObject.get("humidity").toString()));

            JSONArray currentWeather = (JSONArray) jsonObject.get("weather");
            JSONObject description = (JSONObject) currentWeather.get(0);

            String mainDescription = getMainDescription(description.get("description").toString());
            weather.setWeatherDescription(mainDescription);
            hourlyForecast.setWeather(weather);

            list.add(hourlyForecast);
        }

        return (list.toArray(new HourlyForecast[list.size()]));
    }

    /**
     * Method used to filter OpenWeather's daily weather details and create a DailyForecast array
     *
     * @param daily the daily weather data array from the OpenWeather API
     * @return
     */
    private DayForecast[] getDailyForecast(JSONArray daily) {

        ArrayList<DayForecast> list = new ArrayList<>();

        for (Object forecast : daily) {
            DayForecast dayForecast = new DayForecast();
            Weather weather = new Weather();

            JSONObject jsonObject = (JSONObject) forecast;
            Long timestamp = Long.parseLong(jsonObject.get("dt").toString());
            java.util.Date time = new java.util.Date(timestamp * 1000);
            dayForecast.setDate(time);
            dayForecast.setDayOfWeek(getDay(time.getDay()));

            weather.setClouds((Long) jsonObject.get("clouds"));

            JSONObject temp = ((JSONObject) jsonObject.get("temp"));
            Double minTemp = Double.parseDouble(temp.get("min").toString());
            Double maxTemp = Double.parseDouble(temp.get("max").toString());
            Double average = (minTemp + maxTemp) / 2.0;

            weather.setTemp(average);
            weather.setWindSpeed(Double.parseDouble(jsonObject.get("wind_speed").toString()));
            weather.setHumidity(Long.parseLong(jsonObject.get("humidity").toString()));
            JSONArray currentWeather = (JSONArray) jsonObject.get("weather");
            JSONObject description = (JSONObject) currentWeather.get(0);
            String mainDescription = getMainDescription(description.get("description").toString());
            weather.setWeatherDescription(mainDescription);
            dayForecast.setWeather(weather);

            list.add(dayForecast);

        }

        return (list.toArray(new DayForecast[list.size()]));
    }

    /**
     * Method used to read OpenWeather's daily forecast array and create a DailyForecast object for tomorrow's forecast
     *
     * @param daily the daily weather data array from the OpenWeather API
     * @return
     */
    private DayForecast getTomorrowForecast(JSONArray daily) {

        //we start by getting the second forecast in the array, as that is tomorrow's forecast
        JSONObject forecast = (JSONObject) daily.get(1);

        DayForecast dayForecast = new DayForecast();
        Weather weather = new Weather();

        Long timestamp =  Long.parseLong(forecast.get("dt").toString());
        java.util.Date time = new java.util.Date(timestamp * 1000);
        dayForecast.setDate(time);
        dayForecast.setDayOfWeek(getDay(time.getDay()));

        weather.setClouds(Long.parseLong(forecast.get("clouds").toString()));
        JSONObject temp = ((JSONObject) forecast.get("temp"));
        Double minTemp = Double.parseDouble(temp.get("min").toString());
        Double maxTemp = Double.parseDouble(temp.get("max").toString());
        Double average = (minTemp + maxTemp) / 2.0;
        weather.setTemp(average);
        weather.setWindSpeed(Double.parseDouble(forecast.get("wind_speed").toString()));
        weather.setHumidity(Long.parseLong(forecast.get("humidity").toString()));
        JSONArray currentWeather = (JSONArray) forecast.get("weather");
        JSONObject description = (JSONObject) currentWeather.get(0);
        String mainDescription = getMainDescription(description.get("description").toString());
        weather.setWeatherDescription(mainDescription);
        dayForecast.setWeather(weather);

        return dayForecast;
    }

    /**
     * Method used to convert OpenWeather's geolocation details into a Location object
     *
     * @param geolocation geolocation details from the OpenWeather geolocation API
     * @return
     */
    private Location getLocation(Geolocation geolocation) {
        Location location = new Location();

        location.setLatitude(geolocation.getLatitude());
        location.setLongitude(geolocation.getLongitude());
        location.setCityName(geolocation.getCityName());

        return location;
    }

    /**
     * Method to convert int value of day from Date object into a String indicating the day of the week
     *
     * @param day int value of day from Date object
     * @return
     */
    private String getDay(int day) {

        switch (day) {
            case 0:
                return "Sunday";
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            default:
                return "Invalid day";
        }
    }

    /**
     * Method to convert description provided by OpenWeather into a "Main" description
     * @param description the description provided by OpenWeather
     * @return
     */
    public String getMainDescription(String description){
        if (description.contains("thunderstorm")){
            return "Thunderstorm";
        } else if (description.contains("drizzle")){
            return "Drizzle";
        } else if (description.contains("rain")){
            return "Rain";
        } else if (description.contains("snow")){
            return "Snow";
        } else if (description.contains("mist")){
            return "Mist";
        } else if (description.toLowerCase().contains("smoke")){
            return "Smoke";
        } else if (description.toLowerCase().contains("haze")){
            return "Haze";
        } else if (description.contains("dust")){
            return "Dust";
        } else if(description.contains("fog")){
            return "Fog";
        } else if (description.contains("sand")){
            return "Sand";
        } else if (description.contains("ash")){
            return "Ash";
        } else if (description.contains("squalls")){
            return "Squalls";
        } else if (description.contains("clear")){
            return "Clear";
        } else if (description.contains("clouds")){
            return "Clouds";
        } else {
            return "Invalid description";
        }
    }

    public Alert getAlert(JSONArray alerts){

        Alert alert = new Alert();

        try{
            JSONObject firstAlert = (JSONObject) alerts.get(0);
            String event = (String) firstAlert.get("event");
            String description = (String) firstAlert.get("description");

            alert.setTitle(event);
            alert.setMessage(description);
            return alert;
        } catch (Exception e){
            System.out.println("No weather alert in OpenWeather response");
        }

        return null;
    }

}
