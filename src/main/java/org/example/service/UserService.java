package org.example.service;

import org.example.dto.LoginDTO;
import org.example.dto.RegisterDTO;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
    public boolean isUsernameTaken(String username) {
        return userRepository.findByUsername(username).isPresent();
    }
    public boolean isEmailTaken(String email){
        return userRepository.findByEmail(email).isPresent();
    }




    public User registerNewUser(RegisterDTO registerDTO) {

        if(isUsernameTaken(registerDTO.getUsername())) {
            throw new RuntimeException("Username is already taken.");
        }

        if(isEmailTaken(registerDTO.getEmail())){
            throw new RuntimeException("Email is already taken.");
        }

        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword())); // Encrypt the password
        user.setEmail(registerDTO.getEmail());
        return userRepository.save(user);

    }

    public boolean validateUserPassword(String username, String providedPassword) {
        // Retrieve the user by username
        Optional<User> userOpt = userRepository.findByUsername(username);

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            // Compare the provided password with the stored hashed password
            return passwordEncoder.matches(providedPassword, user.getPassword());
        }

        return false;
    }


}
