package com.example.springbootall.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
public class PayService {

    private static int totalNum = 100000;

//    @Retryable(value = {IOException.class,IllegalArgumentException.class}, maxAttempts = 3,
//            backoff = @Backoff(delay = 2000L, maxDelay = 3000L , multiplier = 2))

//    @Retryable(value = {IOException.class,IllegalArgumentException.class}, maxAttemptsExpression = "${retry.maxAttempts}",
//            backoff = @Backoff(delayExpression = "${retry.backoff.delay}", maxDelayExpression = "${retry.backoff.maxDelay}", multiplierExpression = "${retry.backoff.multiplier}"))

    @Retryable(value = {IOException.class,IllegalArgumentException.class}, maxAttemptsExpression = "#{${retry.maxAttempts}}",
            backoff = @Backoff(delayExpression = "#{${retry.backoff.delay}}", maxDelayExpression = "#{${retry.backoff.maxDelay}}", multiplierExpression = "#{${retry.backoff.multiplier}}"))
    public int minGoodsnum(int num) throws Exception{
        log.info("减库存开始:" + DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss").format(LocalDateTime.now()));
        try {
            int i = 1/1;
        } catch (Exception e) {
            throw new IOException("123");
        }
        try {
            int i = 1/0;
        } catch (Exception e) {
            throw new IllegalArgumentException("456");
        }
        log.info("减库存执行结束:" + DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss").format(LocalDateTime.now()));
        return totalNum - num;
    }

    /**
     * @Recover注解修饰的方法:
     * 第一个参数必须是异常,其他参数和@Retryable修饰的方法参数顺序一致(第一个参数必须是异常,其他参数可以不写)
     */
    @Recover
    public int recover(IOException e, int num){
        log.error("减库存失败:num={},msg={}",num,e.getMessage(),e);
        return 9999;
    }

    @Recover
    public int recover(IllegalArgumentException e, int num){
        log.error("减库存失败:num={},msg={}",num,e.getMessage(),e);
        return 8888;
    }

}
