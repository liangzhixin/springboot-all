package com.example.springbootall.config;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import java.io.IOException;

@Slf4j
public class MyFilterOne implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filter one init ...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("filter one doFilter start ...");
        chain.doFilter(request, response);
        log.info("filter one doFilter end ...");
    }

    @Override
    public void destroy() {
        log.info("filter one destroy ...");
    }
}
