package edu.depaul.springbootweatherpoc;

import edu.depaul.springbootweatherpoc.weather.entity.User;
import edu.depaul.springbootweatherpoc.weather.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;

import java.util.List;

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
}
