package com.example.springbootall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@EnableScheduling
@SpringBootApplication
@EnableRetry
//@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@ImportResource(locations = {"classpath:spring-beans.xml"})
@ServletComponentScan
public class SpringbootAllApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootAllApplication.class, args);
//        String[] beanNames = context.getBeanDefinitionNames();
//        for (String beanName : beanNames){
//            System.out.println(beanName + "=====" + context.getBean(beanName).getClass());
//        }
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
