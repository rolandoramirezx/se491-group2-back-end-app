package edu.depaul.springbootweatherpoc.service;

import edu.depaul.springbootweatherpoc.entity.Login;
import edu.depaul.springbootweatherpoc.entity.User;
import edu.depaul.springbootweatherpoc.repository.LoginRepository;
import edu.depaul.springbootweatherpoc.util.PasswordUtils;
import org.springframework.stereotype.Service;
import edu.depaul.springbootweatherpoc.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final LoginRepository loginRepository;

    public UserService(UserRepository userRepository, LoginRepository loginRepository) {
        this.userRepository = userRepository;
        this.loginRepository = loginRepository;
    }

    public User register(User user, String userName, String password) throws Exception {
        // Check if username is already taken
        User existingUser = this.userRepository.findByUserName(userName);

        if (existingUser != null) {
            throw new Exception();
        }

        // Create passHash
        String passHash = PasswordUtils.generateStoringPasswordHash(password);

        // Save user
        User savedUser = this.userRepository.saveAndFlush(user);

        // Save the login
        Login login = Login.builder()
                .userName(userName)
                .passHash(passHash)
                .build();

        this.loginRepository.saveAndFlush(login);

        return savedUser;
    }
    public User login(String userName, String password) throws Exception {
        // Check if user even exists
        User existingUser = this.userRepository.findByUserName(userName);
        if (existingUser == null) {
            throw new Exception();
        }

        // Check if login entry exists
        // Check if user even exists
        Login existingLogin = this.loginRepository.findByUserName(userName);
        if (existingLogin == null) {
            throw new Exception();
        }

        // Verify the password
        boolean isPasswordCorrect =
                PasswordUtils.validatePassword(password, existingLogin.getPassHash());

        if (isPasswordCorrect) {
            /// Verified login
            return existingUser;
        } else {
            // Invalid password
            throw new Exception();
        }

    }
}
