package com.vnbear.springbootdemo.controller;

import com.vnbear.springbootdemo.bean.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    User user;

    @RequestMapping(value = "/")
    public String hello(){
        return user.getName()+","+ user.getAge()+","+ user.getWant();
    }
}
