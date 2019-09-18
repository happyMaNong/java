package com.tlp.java8.constantpool;

/**
 * @author：tlp
 * @crateDate：2019/9/16 20:51
 */
public class TestConstantPool {
    private static String str = "a";
    String str1 = "b";
    public static void main(String[] args){
        String str2 = "c";
        String str4 = "22";
        String str3 = new String("2") + new String("2");

        System.out.println(str3 == str4);
    }
}
