package com.vnbear.springbootdemo.proxy.jdk;

import com.vnbear.springbootdemo.proxy.jdk.HelloWorld;

public class HelloWorldImpl implements HelloWorld {
    @Override
    public void sayHelloWorld() {
        System.out.println("Hello  World");
    }
}
