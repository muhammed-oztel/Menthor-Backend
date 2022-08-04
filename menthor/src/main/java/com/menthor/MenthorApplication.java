package com.menthor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MenthorApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.menthor.MenthorApplication.class, args);
    }

}

