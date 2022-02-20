package edu.depaul.springbootweatherpoc.weather.repository;

import edu.depaul.springbootweatherpoc.weather.model.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<TestEntity, Long> {
}
