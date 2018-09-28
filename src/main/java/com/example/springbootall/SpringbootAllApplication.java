package com.example.springbootall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringbootAllApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAllApplication.class, args);
    }
}
