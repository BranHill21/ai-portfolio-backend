package com.brandonhill.portfolio_backend.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/tester")
@CrossOrigin(origins = {"http://localhost:3000", "https://stockfolioai.netlify.app"})
public class TestPageController {

    @GetMapping
    public Map<String, Object> getSamplePrediction() {
        Map<String, Object> sampleResult = new HashMap<>();
        sampleResult.put("price_change", 5.85);
        sampleResult.put("recommendation", "BUY");
        sampleResult.put("sentiment", 0.0);
        sampleResult.put("symbol", "IBM");
//        String mongoUri = System.getenv("MONGO_URI");
//        System.out.println("MONGO: " + mongoUri);
        return sampleResult;
    }
}