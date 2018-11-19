package com.example.springbootall.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RetryJobSub extends RetryJob{

    @Override
    public boolean execute(String name, Integer age) {
        log.info("入参: name={},age={}", name, age);
        try {
            int i = 1/0;
        } catch (Exception e) {
            throw new IllegalArgumentException("123");
        }
        log.info("结束执行......");
        return true;
    }
}
