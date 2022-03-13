package edu.depaul.springbootweatherpoc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Geolocation {
    private Double latitude;
    private Double longitude;
    private String cityName;
}
