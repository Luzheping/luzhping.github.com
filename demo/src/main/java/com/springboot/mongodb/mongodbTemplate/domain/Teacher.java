package com.springboot.mongodb.mongodbTemplate.domain;

/**
 * Created by luzhp on 2017/4/6.
 */
public class Teacher {
    private String teacherId;
    private String name;
    private String age;

    public String getId() {
        return teacherId;
    }

    public void setId(String id) {
        this.teacherId = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + teacherId + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
