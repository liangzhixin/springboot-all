package com.example.springbootall.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = {"classpath:test.properties"})
public class User3 {

    @Value("${test.name}")
    private String name;

    @Value("${test.age}")
    private String age;

//    @Scheduled(cron = "0/3 * * * * ?")
    public void test(){
        System.out.println(name + ":" + age);
    }
}
