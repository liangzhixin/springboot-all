package com.example.springbootall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringbootAllApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootAllApplication.class, args);
//        String[] beanNames = context.getBeanDefinitionNames();
//        for (String beanName : beanNames){
//            System.out.println(beanName);
//        }
    }
}
