package com.brandonhill.portfolio_backend.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@RestController
@RequestMapping("/api/predict")
@CrossOrigin(origins = {"http://localhost:3000", "https://stockfolioai.netlify.app/"})
public class PredictionController {

    @Value("${flask.api.url}")
    private String flaskApiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping
    public Map<String, Object> getPrediction(@RequestBody Map<String, Object> requestData) {
        return restTemplate.postForObject(flaskApiUrl, requestData, Map.class);
    }
}