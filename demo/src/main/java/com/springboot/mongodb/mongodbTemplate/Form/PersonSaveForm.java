package com.springboot.mongodb.mongodbTemplate.Form;

import com.springboot.mongodb.mongodbTemplate.domain.Person;
import com.springboot.mongodb.mongodbTemplate.domain.Teacher;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luzhp on 2017/4/6.
 */
public class PersonSaveForm {
    private String id;
    private String name;
    private String age;
    private List<Teacher> teacherList;

    public Person toDomain(){
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        person.setAge(age);
        person.setTeacherList(teacherList);
        return  person;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonSaveForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", teacherList=" + teacherList +
                '}';
    }
}
