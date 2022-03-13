package edu.depaul.springbootweatherpoc;

import edu.depaul.springbootweatherpoc.entity.Location;
import edu.depaul.springbootweatherpoc.entity.User;
import edu.depaul.springbootweatherpoc.model.FeedbackDto;
import edu.depaul.springbootweatherpoc.service.FeedbackService;
import edu.depaul.springbootweatherpoc.service.LocationService;
import edu.depaul.springbootweatherpoc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;

@SpringBootApplication
public class SpringBootWeatherPocApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringBootWeatherPocApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWeatherPocApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(
            UserService userService,
            LocationService locationService,
            FeedbackService feedbackService) {
        return (args) -> {
            //save a user to USERS table

            // NOTE: This app is for demo purposes
            // only, for a real use case do not put passwords
            // in src code file
            String testUserName = "rramir3";
            String testPassword = "abc123$Z";

            User testUser = User.builder()
                    .userName(testUserName)
                    .firstName("Rolando")
                    .lastName("Ramirez")
                    .build();

            User savedUser = userService.register(testUser, testUserName, testPassword);//userRepository.saveAndFlush(testUser);
            System.out.println(savedUser);

            Location testLocation1 = Location.builder()
                    .cityName("Chicago")
                    .latitude(41.8781)
                    .longitude(-87.6298)
                    .dateCreated(Instant.now())
                    .userName(savedUser.getUserName())
                    .build();

            Location testLocation2 = Location.builder()
                    .cityName("Des Plaines")
                    .latitude(42.0334)
                    .longitude(-87.8834)
                    .dateCreated(Instant.now())
                    .userName(savedUser.getUserName())
                    .build();


            // Duplicate by city name should replace the last one
            Location testLocation3 = Location.builder()
                    .cityName("Chicago")
                    .latitude(41.8781)
                    .longitude(-87.6298)
                    .dateCreated(Instant.now())
                    .userName(savedUser.getUserName())
                    .build();

            locationService.addRecentlyViewedLocation(testLocation1);
            locationService.addRecentlyViewedLocation(testLocation2);
            locationService.addRecentlyViewedLocation(testLocation3);

            FeedbackDto feedbackTest = FeedbackDto.builder()
                    .userName(savedUser.getUserName())
                    .rating(3)
                    .comments("It is ok I guess")
                    .build();

            feedbackService.createFeedback(feedbackTest);
        };
    }
}
