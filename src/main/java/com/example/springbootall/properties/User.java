package com.example.springbootall.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class User {

    @Value("${lzx.name}")
    private String name;

    @Value("${lzx.age}")
    private String age;

//    @Scheduled(cron = "0/3 * * * * ?")
    public void test(){
        System.out.println(name + ":" + age);
    }
}
