package com.brandonhill.portfolio_backend.service;

import com.brandonhill.portfolio_backend.model.User;
import com.brandonhill.portfolio_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(User user) {

        // Check duplicate username
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }

        // Check duplicate email
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }

        // Hash password
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        return userRepository.save(user);
    }

    public Optional<User> login(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isPresent() &&
            passwordEncoder.matches(password, user.get().getPassword())) {
            return user;
        }

        return Optional.empty();
    }
}