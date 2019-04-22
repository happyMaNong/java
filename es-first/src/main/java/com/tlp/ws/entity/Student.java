package com.tlp.ws.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @className: Student
 * @description:
 * @author: tianlingpeng
 * @create: 2019-04-22 14:47
 */
@Document(indexName = "student")
public class Student {
    @Id
    private Long id;

    @Field(type = FieldType.Keyword)
    private String name;

    private int age;

    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String address;

    @Field(type = FieldType.Date)
    private String birthday;

    private double score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", birthday='" + birthday + '\'' +
                ", score=" + score +
                '}';
    }
}
