package edu.depaul.springbootweatherpoc.feedback.repository;

import edu.depaul.springbootweatherpoc.feedback.model.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedbackEntity, Long> {
}
