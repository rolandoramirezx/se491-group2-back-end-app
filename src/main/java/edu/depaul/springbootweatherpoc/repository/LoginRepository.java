package edu.depaul.springbootweatherpoc.repository;

import edu.depaul.springbootweatherpoc.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {
    Login findByUserName(String userName);
}
