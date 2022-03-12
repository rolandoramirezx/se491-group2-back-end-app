package edu.depaul.springbootweatherpoc.weather.controller;

import edu.depaul.springbootweatherpoc.service.UserLocationService;
import edu.depaul.springbootweatherpoc.weather.model.Location;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequestMapping("login")
public class LoginController {
    private final UserLocationService userLocationService;

    public LoginController(UserLocationService userLocationService) {
        this.userLocationService = userLocationService;
    }

    /**
     * Endpoint used to check for and return any locations associated with a username
     * @param userName
     * @return
     */
    @GetMapping("/userName/{userName}")
    public List<Location> getLocationsByUserName(@PathVariable("userName") String userName) {

        //TODO - use service to check for any locations associated with the username and return them if any are found

        return null;
    }

}
