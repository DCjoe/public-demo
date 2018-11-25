package com.fnl.caesar.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Author dengcheng
 * @Date 2018/11/25
 **/
@SpringBootApplication
public class WebApplication  extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WebApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class,args);
    }
}
