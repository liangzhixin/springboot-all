package com.example.springbootall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Administrator    拦截器配置(拦截器在过滤器后执行)以及静态资源映射
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //先定义的先拦截
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/**").excludePathPatterns("/static/**");
        registry.addInterceptor(myInterceptor()).addPathPatterns("/**").excludePathPatterns("/static/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //静态资源的映射
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    @Bean
    public MyInterceptor myInterceptor() {
        return new MyInterceptor();
    }
}
