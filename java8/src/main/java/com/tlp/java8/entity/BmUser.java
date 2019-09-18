package com.tlp.java8.entity;

import java.io.Serializable;

/**
 * @author：tlp
 * @crateDate：2019/9/18 22:03
 */
public class BmUser implements Serializable,Cloneable{
    AgeAndSex ageAndSex;
    String name;

    public BmUser() {
        ageAndSex = new AgeAndSex(1,"");
    }

    @Override
    public String toString() {
        return "BmUser{" +
                "ageAndSex=" + ageAndSex.getSex()+":"+ageAndSex.getAge() +
                ", name='" + name + '\'' +
                '}';
    }

    public BmUser(AgeAndSex ageAndSex, String name) {
        this.ageAndSex = ageAndSex;
        this.name = name;
    }

    public AgeAndSex getAgeAndSex() {
        return ageAndSex;
    }

    public void setAgeAndSex(AgeAndSex ageAndSex) {
        this.ageAndSex = ageAndSex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
        }
        return obj;
    }
}
