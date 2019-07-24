package com.vnbear.springbootdemo;

import com.vnbear.springbootdemo.bean.UserBean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableConfigurationProperties(UserBean.class)
public class SpringbootdemoApplication  extends SpringBootServletInitializer {

    @RequestMapping("/hello")
    public String index(){
        return "hello Spring Boot";
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringbootdemoApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootdemoApplication.class, args);
    }


}
