package com.tlp.java8.lambda;

/**
 * @className: TestStringPool
 * @description:
 * @author: tianlingpeng
 * @create: 2019-09-18 10:25
 */
public class TestStringPool {
    private String str1 = "abc";

    public static void main(String[] args) {
        String str3 = new String("你好");//
        System.out.println(str3 == str3.intern());//false

        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);//true

    }
}
