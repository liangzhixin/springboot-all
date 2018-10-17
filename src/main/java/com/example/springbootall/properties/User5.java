package com.example.springbootall.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Environment(所有已经被加载的配置都可以读取到)
 */
@Component
public class User5 {

    @Autowired
    private Environment environment;

//    @Scheduled(cron = "0/3 * * * * ?")
    public void test(){
        String name = environment.getProperty("lzx.name");
        String age = environment.getProperty("lzx.age");
        System.out.println(name + ":" + age);

        String name2 = environment.getProperty("test.name");
        String age2 = environment.getProperty("test.age");
        System.out.println(name2 + ":" + age2);
    }
}
