package edu.depaul.springbootweatherpoc;

import edu.depaul.springbootweatherpoc.weather.entity.Location;
import edu.depaul.springbootweatherpoc.weather.entity.Login;
import edu.depaul.springbootweatherpoc.weather.entity.User;
import edu.depaul.springbootweatherpoc.weather.repository.LocationRepository;
import edu.depaul.springbootweatherpoc.weather.repository.LoginRepository;
import edu.depaul.springbootweatherpoc.weather.repository.UserRepository;
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
}
