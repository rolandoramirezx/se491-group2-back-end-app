package edu.depaul.springbootweatherpoc.service;

import edu.depaul.springbootweatherpoc.entity.User;
import org.springframework.stereotype.Service;
import edu.depaul.springbootweatherpoc.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String userName, String password){
        /*
        1- get user from database by userName
        2- if it is not able to find user, throw an error
        3- hash the password argument
        4- compare hash from step3 and the hash from database. If the match, return the user. If not, return an error.
         */
      return null;
    }
}
