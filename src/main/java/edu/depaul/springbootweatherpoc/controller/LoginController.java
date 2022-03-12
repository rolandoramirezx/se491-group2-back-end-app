package edu.depaul.springbootweatherpoc.controller;

import edu.depaul.springbootweatherpoc.service.UserService;
import edu.depaul.springbootweatherpoc.entity.User;
import edu.depaul.springbootweatherpoc.model.LoginDto;
import org.springframework.web.bind.annotation.*;

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
