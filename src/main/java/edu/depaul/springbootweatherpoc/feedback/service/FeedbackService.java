package edu.depaul.springbootweatherpoc.feedback.service;

import edu.depaul.springbootweatherpoc.feedback.model.FeedbackDto;
import edu.depaul.springbootweatherpoc.feedback.model.FeedbackEntity;
import edu.depaul.springbootweatherpoc.feedback.repository.FeedbackRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public void createFeedback(@RequestBody FeedbackDto feedbackDto) throws Exception {
        FeedbackEntity feedbackEntity = FeedbackEntity.builder()
                                        .id(null)
                                        .userId(feedbackDto.getUserId())
                                        .rating(feedbackDto.getRating())
                                        .comments(feedbackDto.getComments())
                                        .build();

        this.feedbackRepository.save(feedbackEntity);
    }
}
