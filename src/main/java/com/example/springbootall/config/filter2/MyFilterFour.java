package com.example.springbootall.config.filter2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 *  1.这种方式需要主类添加@ServletComponentScan注解
 *  2.过滤器执行顺序:根据类名的自然顺序排名, MyFilterFive > MyFilterFour > MyFilterSix > MyFilterThree
 *  3.经测试后发现@Order并不能控制过滤器的执行顺序
 */
@WebFilter(filterName = "filter4", urlPatterns = {"/*"})
@Slf4j
public class MyFilterFour implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filter four init ...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("filter four doFilter start ...");
        chain.doFilter(request, response);
        log.info("filter four doFilter end ...");
    }

    @Override
    public void destroy() {
        log.info("filter four destroy ...");
    }
}
