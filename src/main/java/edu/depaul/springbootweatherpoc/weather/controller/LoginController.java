package edu.depaul.springbootweatherpoc.weather.controller;

import edu.depaul.springbootweatherpoc.service.UserLocationService;
import edu.depaul.springbootweatherpoc.service.UserService;
import edu.depaul.springbootweatherpoc.weather.entity.User;
import edu.depaul.springbootweatherpoc.weather.model.Location;
import edu.depaul.springbootweatherpoc.weather.model.LoginDto;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("login")
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public User login(@RequestBody LoginDto credentials){
       return this.userService.login(credentials.getUserName(),credentials.getPassword());
    }

}
