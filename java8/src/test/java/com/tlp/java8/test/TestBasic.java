package com.tlp.java8.test;

import org.junit.Test;

/**
 * @author：tlp
 * @crateDate：2019/9/16 19:36
 */
public class TestBasic {
    @Test
    public void testStringPool() {
        String str1 = "abc";
        System.out.println(str1.hashCode());
        String str2 = "abc";
        System.out.println(str1==str2);

        String str3 = new String("abc");
        System.out.println(str3.hashCode());
        System.out.println(str1==str3);
        System.out.println(str1.equals(str3));
    }
}
