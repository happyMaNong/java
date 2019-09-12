package com.tlp.designpattern.creation.simpleFactory;

/**
 * @className: ServiceImpl1
 * @description:
 * @author: tianlingpeng
 * @create: 2019-09-12 10:59
 */
public class ServiceImpl1 implements Service {
    @Override
    public void method1() {
        System.out.println("ServiceImpl1：method1");
    }

    @Override
    public void method2() {
        System.out.println("ServiceImpl1：method2");
    }
}
