package com.example.springbootall.config.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Request监听器,需要主类添加@ServletComponentScan注解,还有对Request属性的监听器,这里不做了解
 */
@WebListener
@Slf4j
public class MyServletRequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent event) {
        HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
        log.info("请求开始... request url:" + request.getRequestURL());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent event) {
        log.info("请求结束...");
    }

}
