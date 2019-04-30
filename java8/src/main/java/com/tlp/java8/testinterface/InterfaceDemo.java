package com.tlp.java8.testinterface;

/**
 * @className: InterfaceDemo
 * @description: 默认接口方法
 * @author: tianlingpeng
 * @create: 2019-04-27 15:26
 */
public interface InterfaceDemo {
    String sayHello();

    default void sayHi(){
        System.out.println("Hi");
    }
}
