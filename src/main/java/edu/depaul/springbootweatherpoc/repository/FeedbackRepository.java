package edu.depaul.springbootweatherpoc.repository;

import edu.depaul.springbootweatherpoc.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
