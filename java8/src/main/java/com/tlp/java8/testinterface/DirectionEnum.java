package com.tlp.java8.testinterface;

public enum DirectionEnum {
    west("西"),north("南"),south("北"),east("东");

    private String name;

    DirectionEnum(String name) {
        this.name = name;
    }
}
