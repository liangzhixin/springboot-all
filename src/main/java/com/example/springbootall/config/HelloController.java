package com.example.springbootall.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Administrator    测试
 */
@RestController
@Slf4j
public class HelloController {

    @GetMapping("/hello")
    public String hello(HttpSession session){
        return "hello world";
    }

    @PostMapping("/hello2")
    public String hello2(){
        return "hello world";
    }
}
