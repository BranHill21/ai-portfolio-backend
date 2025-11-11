package com.brandonhill.portfolio_backend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brandonhill.portfolio_backend.config.MongoAtlasConnector;

@SpringBootApplication
public class PortfolioBackendApplication implements CommandLineRunner {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @Value("${spring.data.mongodb.database}")
    private String dbName;

    public static void main(String[] args) {
        SpringApplication.run(PortfolioBackendApplication.class, args);
    }

    @Override
    public void run(String... args) {
        MongoAtlasConnector.init(mongoUri, dbName);
    }
}
