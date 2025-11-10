package com.brandonhill.portfolio_backend.controller;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

@Component
public class TestController implements InitializingBean {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @Override
    public void afterPropertiesSet() {
    	System.out.println("!!!ME ME ME!!! Mongo URI = " + mongoUri);
    }
}