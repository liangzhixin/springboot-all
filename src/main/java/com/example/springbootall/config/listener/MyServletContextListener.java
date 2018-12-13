package com.example.springbootall.config.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * ServletContext监听器,需要主类添加@ServletComponentScan注解,还有对ServletContext属性的监听器,这里不做了解
 */
@WebListener
@Slf4j
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        log.info("ServletContext初始化...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        log.info("ServletContext销毁...");
    }
}
