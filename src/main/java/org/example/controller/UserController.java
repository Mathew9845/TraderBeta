package org.example.controller;

import org.example.dto.LoginDTO;
import org.example.dto.RegisterDTO;
import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registeruser/")
    public ResponseEntity<String> registerUser(@RequestBody RegisterDTO registerDTO){
        userService.registerNewUser(registerDTO);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login/")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        boolean isAuthenticated = userService.validateUserPassword(loginDTO.getUsername(), loginDTO.getPassword());

        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
}
