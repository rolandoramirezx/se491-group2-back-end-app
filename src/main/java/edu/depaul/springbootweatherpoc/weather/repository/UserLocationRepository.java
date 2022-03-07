package edu.depaul.springbootweatherpoc.weather.repository;

import edu.depaul.springbootweatherpoc.weather.entity.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLocationRepository extends JpaRepository<UserLocation, Long> {

}
