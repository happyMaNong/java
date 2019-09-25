package com.tlp.java8.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @className: TestJdkProxy
 * @description:
 * @author: tianlingpeng
 * @create: 2019-09-12 14:24
 */
public class TestJdkProxy {
    public static void main(String[] args) {
        Developer developer = new JavaDeveloper();

        Developer developer1 = (Developer) Proxy
                .newProxyInstance(developer.getClass().getClassLoader(), developer.getClass().getInterfaces(), (proxy, method, arg) -> {
                    if (method.getName().equals("code")) {
                        System.out.println("没bug");
                        method.invoke(developer, args);
                    }
                    return null;
                });
        developer1.code();
    }
}
