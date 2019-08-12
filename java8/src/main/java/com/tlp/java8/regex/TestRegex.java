package com.tlp.java8.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @className: TestRegex
 * @description: 正则表达式
 * @author: tianlingpeng
 * @create: 2019-06-24 08:45
 */
public class TestRegex {
    public static void main(String[] args){
        String str = "(?<=contain\\().*(?=\\))";

        Pattern pattern = Pattern.compile(str);
        Matcher matcher = pattern.matcher("contain({305/##/a},(影印本),2)");

        if (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
