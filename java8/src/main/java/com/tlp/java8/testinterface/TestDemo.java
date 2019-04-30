package com.tlp.java8.testinterface;

import java.util.Map;

/**
 * @className: TestDemo
 * @description:
 * @author: tianlingpeng
 * @create: 2019-04-27 15:28
 */
public class TestDemo {
    public static void main(String[] args){
        InterfaceDemo interfaceDemo = new InterfaceDemoImpl();
        System.out.println(interfaceDemo.sayHello());
        interfaceDemo.sayHi();
    }
}
