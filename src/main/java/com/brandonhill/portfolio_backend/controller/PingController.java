package com.brandonhill.portfolio_backend.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ping")
@CrossOrigin(origins = {"http://localhost:3000", "https://stockfolioai.netlify.app/"})
public class PingController {
	
	@GetMapping
    public ResponseEntity<?> ping() {
        return ResponseEntity.ok(Map.of("status", "awake"));
    }
}
