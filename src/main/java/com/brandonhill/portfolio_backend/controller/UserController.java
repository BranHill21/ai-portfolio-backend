package com.brandonhill.portfolio_backend.controller;

import com.brandonhill.portfolio_backend.model.User;
import com.brandonhill.portfolio_backend.service.UserService;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = {"http://localhost:3000", "https://stockfolioai.netlify.app/"})
public class UserController {
	
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.register(user));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public Optional<User> login(@RequestBody User user) {
        return userService.login(user.getUsername(), user.getPassword());
    }
}