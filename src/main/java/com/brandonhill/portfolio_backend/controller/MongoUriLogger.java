package com.brandonhill.portfolio_backend.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MongoUriLogger implements CommandLineRunner {
    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @Override
    public void run(String... args) {
        System.out.println("Mongo URI in use: " + mongoUri);
    }
}