package com.example.springbootall.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import java.io.IOException;

@Slf4j
public class MyFilterTwo implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filter two init ...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("filter two doFilter start ...");
        chain.doFilter(request, response);
        log.info("filter two doFilter end ...");
    }

    @Override
    public void destroy() {
        log.info("filter two destroy ...");
    }
}
