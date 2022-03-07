package edu.depaul.springbootweatherpoc.weather.repository;

import edu.depaul.springbootweatherpoc.weather.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
