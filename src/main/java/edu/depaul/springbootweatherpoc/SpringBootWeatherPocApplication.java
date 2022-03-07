package edu.depaul.springbootweatherpoc;

import edu.depaul.springbootweatherpoc.weather.entity.*;
import edu.depaul.springbootweatherpoc.weather.repository.*;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;

@SpringBootApplication
public class SpringBootWeatherPocApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringBootWeatherPocApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWeatherPocApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            //save a user to USERS table
            User testUser = new User();
            testUser.setUserName("rramir3");
            testUser.setFirstName("Rolando");
            testUser.setLastName("Ramirez");
            repository.save(testUser);

            for (User user : repository.findByUserName("rramir3")) {
                //iterate over each user (one at this point), and log their information
                log.info(user.toString());
            }

        };
    }

    @Bean
    public CommandLineRunner locationDemo(LocationRepository repository) {
        return (args) -> {

            Location testLocation = new Location();
            testLocation.setCityName("Chicago");
            testLocation.setZipCode("60632");
            testLocation.setLatitude(0.00);
            testLocation.setLongitude(0.00);
            repository.save(testLocation);

            for (Location location : repository.findLocationByCityName("Chicago")) {
                //iterate over each location (one at this point), and log their information
                log.info(location.toString());
            }

        };
    }

    @Bean
    public CommandLineRunner loginDemo(LoginRepository repository) {
        return (args) -> {

            Login testLogin = new Login();
            User user = new User();
            user.setUserName("rramir3");
            user.setFirstName("Rolando");
            user.setLastName("Ramirez");
            testLogin.setUser(user);
            testLogin.setId(0);
            repository.save(testLogin);

            for (Login login : repository.findAll()) {
                //iterate over each login (one at this point), and log their information
                log.info(login.toString());
            }

        };
    }

    @Bean
    public CommandLineRunner userLocationDemo(UserLocationRepository repository) {
        return (args) -> {

            User user = new User();
            user.setUserName("rramir3");
            user.setFirstName("Rolando");
            user.setLastName("Ramirez");

            Location location = new Location();
            location.setCityName("Chicago");
            location.setZipCode("60632");
            location.setLatitude(0.00);
            location.setLongitude(0.00);

            UserLocation userLocationTest = new UserLocation();
            userLocationTest.setUser(user);
            userLocationTest.setLocation(location);
            userLocationTest.setId(0);

            repository.save(userLocationTest);

            for (UserLocation userLocation : repository.findAll()) {
                //iterate over each user location (one at this point), and log their information
                log.info(userLocation.toString());
            }

        };
    }

    @Bean
    public CommandLineRunner feedbackDemo(FeedbackRepository repository) {
        return (args) -> {

            User user = new User();
            user.setUserName("rramir3");
            user.setFirstName("Rolando");
            user.setLastName("Ramirez");

            Feedback feedbackTest = new Feedback();
            feedbackTest.setId(0);
            feedbackTest.setUserId("rramir3");
            feedbackTest.setUser(user);
            feedbackTest.setRating(0);
            feedbackTest.setComments("comments");

            repository.save(feedbackTest);

            for (Feedback feedback : repository.findAll()) {
                //iterate over each feedback (one at this point), and log their information
                log.info(feedback.toString());
            }

        };
    }
}
