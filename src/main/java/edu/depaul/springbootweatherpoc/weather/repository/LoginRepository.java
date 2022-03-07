package edu.depaul.springbootweatherpoc.weather.repository;

import edu.depaul.springbootweatherpoc.weather.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoginRepository extends JpaRepository<Login, Long> {

    List<Login> findLoginById(int id);
//    List<Login> findLoginByUserName(String userName);
//    List<Login> findLoginByPassword(String password);

}
