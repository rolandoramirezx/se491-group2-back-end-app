package edu.depaul.springbootweatherpoc.model;

public class Weather {

    private Double temp;
    private Long humidity;
    private Double windSpeed;
    private Long currentClouds;
    private String weatherDescription;

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Long getHumidity() {
        return humidity;
    }

    public void setHumidity(Long humidity) {
        this.humidity = humidity;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Long getCurrentClouds() {
        return currentClouds;
    }

    public void setClouds(Long currentClouds) {
        this.currentClouds = currentClouds;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }
}
