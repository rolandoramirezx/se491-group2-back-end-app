package edu.depaul.springbootweatherpoc.weather.repository;

import edu.depaul.springbootweatherpoc.weather.entity.Location;
import edu.depaul.springbootweatherpoc.weather.model.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    List<Location> findLocationByCityName(String cityName);
    List<Location> findLocationByZipCode(String zipCode);
    List<Location> findLocationByLongitude(double longitude);
    List<Location> findLocationByLatitude(double latitude);

}
