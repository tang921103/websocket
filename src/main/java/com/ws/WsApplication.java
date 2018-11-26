package com.ws;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.ws.dao")
public class WsApplication extends SpringBootServletInitializer {
    //以tomcat启动
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WsApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(WsApplication.class, args);
    }
}
