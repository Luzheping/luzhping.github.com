package com.springboot.mongodb.mongodbTemplate.domain;

import java.util.List;

/**
 * Created by luzhp on 2017/4/6.
 */
public class Person {
    private String id;
    private String name;
    private String age;
    private List<Teacher> teacherList;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", teacherList=" + teacherList +
                '}';
    }
}
