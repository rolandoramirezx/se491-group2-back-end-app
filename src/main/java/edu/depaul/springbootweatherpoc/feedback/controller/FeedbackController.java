package edu.depaul.springbootweatherpoc.feedback.controller;

import edu.depaul.springbootweatherpoc.feedback.model.FeedbackDto;
import edu.depaul.springbootweatherpoc.feedback.service.FeedbackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("feedback")
public class FeedbackController {
    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public ResponseEntity<String> createFeedback(@RequestBody FeedbackDto feedbackDto) {
        try {
            this.feedbackService.createFeedback(feedbackDto);
            return ResponseEntity.ok().build();
        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
