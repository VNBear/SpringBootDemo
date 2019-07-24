package com.vnbear.springbootdemo.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyExample implements MethodInterceptor {

    public Object getProxy(Class cls) {
        //CGLIB enhancer增强类对象
        Enhancer enhancer = new Enhancer();
        //设置增强类型
        enhancer.setSuperclass(cls);
        //定义代理逻辑对象为当前对象
        enhancer.setCallback(this);
        //并返回代理对象
        return enhancer.create();
    }

    /**
     *
     * @param o 代理对象
     * @param method 方法
     * @param objects 方法参数
     * @param methodProxy 方法代理
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.err.println("调用真实对象前");
        //CGLIB反射调用真实对象方法
        Object result = methodProxy.invokeSuper(o,objects);
        System.err.println("调用真实对象后");
        return result;
    }
}
