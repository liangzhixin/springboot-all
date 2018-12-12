package com.example.springbootall.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Administrator    过滤器配置(过滤器在拦截器前执行)
 */
//@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean1(){
        FilterRegistrationBean<MyFilterOne> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(myFilterOne());
        registrationBean.setName("filter1");
        registrationBean.addUrlPatterns("/*");
        //数字大的后执行
        registrationBean.setOrder(5);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean2(){
        FilterRegistrationBean<MyFilterTwo> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(myFilterTwo());
        registrationBean.setName("filter2");
        registrationBean.addUrlPatterns("/*");
        //数字小的先执行
        registrationBean.setOrder(3);
        return registrationBean;
    }

    @Bean
    public MyFilterOne myFilterOne(){
        return new MyFilterOne();
    }

    @Bean
    public MyFilterTwo myFilterTwo(){
        return new MyFilterTwo();
    }
}
