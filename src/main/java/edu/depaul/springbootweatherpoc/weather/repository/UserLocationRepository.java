package edu.depaul.springbootweatherpoc.weather.repository;

import edu.depaul.springbootweatherpoc.weather.entity.Location;
import edu.depaul.springbootweatherpoc.weather.entity.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserLocationRepository extends JpaRepository<UserLocation, Long> {

    List<Location> findUserLocationByUserName(String userName);
    List<Location> findAllUserLocationsByUserName(String userName);
}
