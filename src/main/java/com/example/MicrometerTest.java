package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Slf4j
@SpringBootApplication(exclude = RedisAutoConfiguration.class)
@EnableConfigurationProperties
public class MicrometerTest {
    public static void main(String[] args) {
        SpringApplication.run(MicrometerTest.class, args);
    }
}
