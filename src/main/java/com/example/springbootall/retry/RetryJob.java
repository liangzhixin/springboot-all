package com.example.springbootall.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

@Slf4j
public class RetryJob {

    @Retryable(value = {Exception.class}, maxAttemptsExpression = "#{${retry.maxAttempts}}",
            backoff = @Backoff(delayExpression = "#{${retry.backoff.delay}}", maxDelayExpression = "#{${retry.backoff.maxDelay}}", multiplierExpression = "#{${retry.backoff.multiplier}}"))
    public boolean execute(String name, Integer age){
        return true;
    }

    @Recover
    public boolean recover(Exception e, String name, Integer age){
        log.error("入参: name={},age={}, 出现异常:{}", name, age, e.getMessage(), e);
        return false;
    }
}
