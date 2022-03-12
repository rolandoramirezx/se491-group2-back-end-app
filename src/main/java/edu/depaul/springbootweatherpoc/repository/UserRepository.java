package edu.depaul.springbootweatherpoc.repository;

import edu.depaul.springbootweatherpoc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);
    User findById(long id);
}
