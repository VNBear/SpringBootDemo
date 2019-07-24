package com.vnbear.springbootdemo.controller;

import com.vnbear.springbootdemo.bean.UserBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    UserBean userBean;

    @RequestMapping(value = "/")
    public String hello(){
        return userBean.getName()+","+ userBean.getAge()+","+userBean.getWant();
    }
}
