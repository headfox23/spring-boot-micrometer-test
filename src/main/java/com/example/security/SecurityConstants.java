package com.example.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Optional;

@Slf4j
public class SecurityConstants {
    private SecurityConstants() {
        // hide public constructor
    }

    protected static final String[] freeEndpoints = {
            "/v2/**", // Swagger
            "/swagger-resources/**", // Swagger
            "/webjars/**", // Swagger
            "/api/test", //public app info...
            "/actuator/prometheus" // prom
    };
    protected static final String[] protectedEndpoints = {
            "/api/**" // API
    };
}
