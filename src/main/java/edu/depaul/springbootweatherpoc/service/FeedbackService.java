package edu.depaul.springbootweatherpoc.service;

import edu.depaul.springbootweatherpoc.entity.Feedback;
import edu.depaul.springbootweatherpoc.model.FeedbackDto;
import edu.depaul.springbootweatherpoc.repository.FeedbackRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public void createFeedback(@RequestBody FeedbackDto feedbackDto) throws Exception {
        Feedback feedback = Feedback.builder()
                                        .userName(feedbackDto.getUserName())
                                        .rating(feedbackDto.getRating())
                                        .comments(feedbackDto.getComments())
                                        .build();

        this.feedbackRepository.save(feedback);
    }
}
