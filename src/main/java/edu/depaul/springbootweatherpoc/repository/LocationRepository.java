package edu.depaul.springbootweatherpoc.repository;

import edu.depaul.springbootweatherpoc.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findAllByUserName(String userName);
}
