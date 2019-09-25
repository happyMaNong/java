package com.tlp.java8.proxy;

/**
 * @className: JavaDeveloper
 * @description:
 * @author: tianlingpeng
 * @create: 2019-09-12 14:23
 */
public class JavaDeveloper implements Developer {
    @Override
    public void code() {
        System.out.println("写代码");
    }

    @Override
    public void debug() {
        System.out.println("调试bug");

    }
}
