package com.tlp.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @className: LambadDemo
 * @description: Lambda 表达式
 * @author: tianlingpeng
 * @create: 2019-04-27 15:31
 */
public class LambadDemo {
    public static void main(String[] args) {
        //java8之前实现list排序
        List<String> list = Arrays.asList("a", "c", "d", "b");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        //System.out.println(list.toString());
        //用lambda表达式
        Collections.sort(list, (String a, String b) -> {
            return a.compareTo(b);
        });
        System.out.println(list.toString());

        String sperator = ",";
        list.forEach((e) -> System.out.println(e + sperator));

        TestFunction testFunction = new TestFunction();
        testFunction.sayHello("jame", () -> {
            return "hello";
        });
    }
}
