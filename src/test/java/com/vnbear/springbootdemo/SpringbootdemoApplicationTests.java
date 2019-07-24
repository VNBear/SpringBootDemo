package com.vnbear.springbootdemo;

import com.vnbear.springbootdemo.proxy.interceptor.InterceptorJdkProxy;
import com.vnbear.springbootdemo.proxy.jdk.HelloWorld;
import com.vnbear.springbootdemo.proxy.jdk.HelloWorldImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootdemoApplicationTests {

    @Test
    public void contextLoads() {
        /*JdkProxyExample jdkProxyExample = new JdkProxyExample();
        HelloWorld proxy = (HelloWorld) jdkProxyExample.bind(new HelloWorldImpl());
        proxy.sayHelloWorld();*/

        /*CglibProxyExample cglibProxyExample = new CglibProxyExample();
        ReflectServiceImpl obj = (ReflectServiceImpl) cglibProxyExample.getProxy(ReflectServiceImpl.class);
        obj.sayHello("张三");*/

        HelloWorld proxy = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImpl(), "com.vnbear.springbootdemo.proxy.interceptor.MyIntercepter");
        proxy.sayHelloWorld();
    }

}
