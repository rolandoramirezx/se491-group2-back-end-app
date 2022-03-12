package edu.depaul.springbootweatherpoc.repository;

import edu.depaul.springbootweatherpoc.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoginRepository extends JpaRepository<Login, Long> {

    List<Login> findLoginByLoginId(Long id);

}
