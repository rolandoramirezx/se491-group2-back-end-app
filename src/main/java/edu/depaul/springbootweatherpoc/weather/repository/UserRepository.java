package edu.depaul.springbootweatherpoc.weather.repository;

import edu.depaul.springbootweatherpoc.weather.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUserName(String userName);
    List<User> findByFirstName(String firstName);
    List<User> findByLastName(String lastName);
    User findById(long id);
}
