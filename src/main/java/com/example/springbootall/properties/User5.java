package com.example.springbootall.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Environment:
 *  1.读取默认配置文件的属性
 *  2.如果需要读取自定义配置文件,需要加载该配置文件才能读取(通过@PropertySource加载)
 */
//@Component
public class User5 {

    @Autowired
    private Environment environment;

    @Scheduled(cron = "0/3 * * * * ?")
    public void test(){
        //读取默认配置文件的属性
        String name = environment.getProperty("lzx.name");
        String age = environment.getProperty("lzx.age");
        System.out.println(name + ":" + age);

        //读取自定义配置文件的属性(需要先加载才能读取)
        String name2 = environment.getProperty("test.name");
        String age2 = environment.getProperty("test.age");
        System.out.println(name2 + ":" + age2);
    }
}
