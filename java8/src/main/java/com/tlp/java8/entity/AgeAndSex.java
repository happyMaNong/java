package com.tlp.java8.entity;

import java.io.Serializable;

/**
 * @author：tlp
 * @crateDate：2019/9/18 22:03
 */
public class AgeAndSex implements Serializable {
    int age;
    String sex;

    public AgeAndSex() {
    }

    public AgeAndSex(int age, String sex) {
        this.age = age;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
