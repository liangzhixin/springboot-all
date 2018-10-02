package com.example.springbootall.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = {"classpath:test.properties"})
@ConfigurationProperties(prefix = "test")
public class User4 {

    private String name;

    private String age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

//    @Scheduled(cron = "0/3 * * * * ?")
    public void test(){
        System.out.println(name + ":" + age);
    }
}
