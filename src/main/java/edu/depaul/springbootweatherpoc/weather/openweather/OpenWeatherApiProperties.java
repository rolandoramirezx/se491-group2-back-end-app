package edu.depaul.springbootweatherpoc.weather.openweather;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ConfigurationProperties(prefix = "open-weather")
@Configuration("openWeatherApiProperties")
public class OpenWeatherApiProperties {
    String apiBaseUrl;
    String apiGeoBaseUrl;
    String apiZipGeoBaseUrl;
    String apiOneCallBaseUrl;
    String apiKey;
}
