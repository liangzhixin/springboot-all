package com.example.springbootall.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class ScheduleTask {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    /**
     *  上一次 开始执行时间点之后 3 秒再执行,单位ms
     */
//    @Scheduled(fixedRate = 3*1000)
    public void schduleAtFixedRate() throws InterruptedException {
        Thread.sleep(1000);
        log.info("current time : " + sdf.format(new Date()));
    }

    /**
     *  上一次 执行完之后 3 秒再执行,单位ms
     */
//    @Scheduled(fixedDelay = 3*1000)
    public void schduleAtFixedDelay() throws InterruptedException {
        Thread.sleep(1000);
        log.info("current time : " + sdf.format(new Date()));
    }

    /**
     *  第一次延迟 2 秒后执行，之后按 fixedRate 的规则每 3 秒执行一次,单位ms
     */
//    @Scheduled(initialDelay = 2*1000, fixedRate = 3*1000)
    public void scheduleWithInitialAndFixedRate() throws InterruptedException {
        Thread.sleep(1000);
        log.info("current time : " + sdf.format(new Date()));
    }

    /**
     *  第一次延迟 2 秒后执行，之后按 fixedDelay 的规则每 3 秒执行一次,单位ms
     */
//    @Scheduled(initialDelay = 2*1000, fixedDelay = 3*1000)
    public void scheduleWithInitialAndFixedDelay() throws InterruptedException {
        Thread.sleep(1000);
        log.info("current time : " + sdf.format(new Date()));
    }

    /**
     *  根据 cron 表达式定义，每隔 3 秒执行一次
     */
//    @Scheduled(cron = "0/3 * * * * ?")
    public void scheduleWithCron() throws InterruptedException {
        log.info("current time : " + sdf.format(new Date()));
    }
}
