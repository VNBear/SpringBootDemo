package com.vnbear.springbootdemo.proxy.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InterceptorJdkProxy implements InvocationHandler {

    private Object target;  //真实对象
    private String interceptorClass = null;//拦截器全限定名

    public InterceptorJdkProxy(Object target, String interceptorClass) {
        this.target = target;
        this.interceptorClass = interceptorClass;
    }

    /**
     * @param target
     * @param interceptorClass
     * @return
     */
    public static Object bind(Object target, String interceptorClass) {
        //取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InterceptorJdkProxy(target, interceptorClass));
    }

    /**
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (interceptorClass == null) {
            //没有设置拦截器，直接反射原有方法
            return method.invoke(target, args);
        }
        Object result = null;
        //反射生成拦截器
        Interceptor interceptor = (Interceptor) Class.forName(interceptorClass).newInstance();
        if (interceptor.before(proxy, target, method, args)) {
            //反射原有方法
            result = method.invoke(target, args);
        } else {
            //执行around
            interceptor.around(proxy, target, method, args);
        }
        //后置方法
        interceptor.after(proxy, target, method, args);
        return result;
    }
}
