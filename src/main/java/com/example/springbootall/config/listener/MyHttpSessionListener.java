package com.example.springbootall.config.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Session监听器,需要主类添加@ServletComponentScan注解,还有对Session属性的监听器,这里不做了解
 */
@WebListener
@Slf4j
public class MyHttpSessionListener implements HttpSessionListener {

    private Long count = 0L;

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        log.info("创建session...");
        event.getSession().getServletContext().setAttribute("count", ++count);
        log.info("当前在线人数:" + event.getSession().getServletContext().getAttribute("count"));
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        log.info("销毁session...");
        event.getSession().getServletContext().setAttribute("count", --count);
        log.info("当前在线人数:" + event.getSession().getServletContext().getAttribute("count"));
    }
}
