package com.test.springboottest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan//扫描监听器
public class SpringboottestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringboottestApplication.class, args);
    }
}
