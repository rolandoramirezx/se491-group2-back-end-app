package edu.depaul.springbootweatherpoc;

import edu.depaul.springbootweatherpoc.entity.*;
import edu.depaul.springbootweatherpoc.repository.FeedbackRepository;
import edu.depaul.springbootweatherpoc.repository.LocationRepository;
import edu.depaul.springbootweatherpoc.repository.LoginRepository;
import edu.depaul.springbootweatherpoc.repository.UserRepository;
import edu.depaul.springbootweatherpoc.service.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.util.*;

@SpringBootApplication
public class SpringBootWeatherPocApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringBootWeatherPocApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWeatherPocApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(
            UserRepository userRepository,
            LoginRepository loginRepository,
            LocationService locationService,
            FeedbackRepository feedbackRepository) {
        return (args) -> {
            //save a user to USERS table
            User testUser = User.builder()
                    .userName("rramir3")
                    .firstName("Rolando")
                    .lastName("Ramirez")
                    .build();

            User savedUser = userRepository.saveAndFlush(testUser);
            System.out.println(savedUser);

            Login testLogin = Login.builder()
                    .userName(savedUser.getUserName())
                    .build();
            loginRepository.saveAndFlush(testLogin);

            Location testLocation1 = Location.builder()
                    .cityName("Chicago")
                    .zipCode("60632")
                    .latitude(41.8781)
                    .longitude(-87.6298)
                    .dateCreated(Instant.now())
                    .userName(savedUser.getUserName())
                    .build();

            Location testLocation2 = Location.builder()
                    .cityName("Des Plaines")
                    .zipCode("60016")
                    .latitude(42.0334)
                    .longitude(-87.8834)
                    .dateCreated(Instant.now())
                    .userName(savedUser.getUserName())
                    .build();

            Location testLocation3 = Location.builder()
                    .cityName("Chicago")
                    .zipCode("60016")
                    .latitude(42.0334)
                    .longitude(-87.8834)
                    .dateCreated(Instant.now())
                    .userName(savedUser.getUserName())
                    .build();

            locationService.addRecentlyViewedLocation(testLocation1);
            locationService.addRecentlyViewedLocation(testLocation2);
            locationService.addRecentlyViewedLocation(testLocation3);

            Feedback feedbackTest = Feedback.builder()
                    .userName(savedUser.getUserName())
                    .rating(3)
                    .comments("It is ok I guess")
                    .build();
            feedbackRepository.saveAndFlush(feedbackTest);
        };
    }
}
