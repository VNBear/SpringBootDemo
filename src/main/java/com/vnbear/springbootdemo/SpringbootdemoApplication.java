package com.vnbear.springbootdemo;

import com.vnbear.springbootdemo.bean.User;
import com.vnbear.springbootdemo.utils.MyBaseDao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
//启注解事务管理
@EnableTransactionManagement  // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@EnableConfigurationProperties(User.class)
@MapperScan(basePackages = "com.vnbear.springbootdemo",markerInterface = MyBaseDao.class)
public class SpringbootdemoApplication extends SpringBootServletInitializer {

    @RequestMapping("/hello")
    public String index() {
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
