package com.example.tododevelop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TodoDevelopApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoDevelopApplication.class, args);
    }

}
