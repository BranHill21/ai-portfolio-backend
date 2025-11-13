package com.brandonhill.portfolio_backend.service;

import com.brandonhill.portfolio_backend.model.User;
import com.brandonhill.portfolio_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
    	Optional<User> testUser = userRepository.findByUsername(user.getUsername());
    	if(!testUser.equals(null)) {
    		return userRepository.save(user);
    	}
    	else {
    		return null;
    	}
    }

    public Optional<User> login(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user;
        }
        return Optional.empty();
    }
}