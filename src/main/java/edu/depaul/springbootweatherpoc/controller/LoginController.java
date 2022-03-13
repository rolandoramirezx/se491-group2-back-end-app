package edu.depaul.springbootweatherpoc.controller;

import edu.depaul.springbootweatherpoc.service.UserService;
import edu.depaul.springbootweatherpoc.entity.User;
import edu.depaul.springbootweatherpoc.model.LoginDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<User> login(@RequestBody LoginDto credentials) {
        try {
            User user = this.userService.login(credentials.getUserName(),credentials.getPassword());
            return ResponseEntity.ok(user);
        } catch (Exception exception) {
            return ResponseEntity.status(401).build();
        }

    }

}
