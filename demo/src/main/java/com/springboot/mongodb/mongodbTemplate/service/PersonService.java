package com.springboot.mongodb.mongodbTemplate.service;

import com.springboot.mongodb.mongodbTemplate.Exception.FollowupException;
import com.springboot.mongodb.mongodbTemplate.Response.Page;
import com.springboot.mongodb.mongodbTemplate.dao.PersonDao;
import com.springboot.mongodb.mongodbTemplate.domain.Person;
import com.springboot.mongodb.mongodbTemplate.id.IdGenerators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by luzhp on 2017/4/6.
 */
@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;

    public Person save(Person p){
        try{
            String id = IdGenerators.uuid();
            p.setId(id);
            p.getTeacherList().forEach(e->{
                e.setId(IdGenerators.uuid());
            });
            personDao.save(p);
            return get(p.getId());
        }catch (FollowupException e){
            throw new FollowupException("无");
        }
    }

    public Person update(Person p){
        personDao.update(p);
        return get(p.getId());
    }

    public void delete(List<String>  ids){
        System.out.println(ids);
        personDao.delete(ids);
    }

    public Page<Person> query(int limit , int size){
        int count = (int)personDao.count();
        List<Person>  data = personDao.query(limit , size);
        return new Page<>(count , data);
    }

    public Person get(String id){
        try{
            Person p = personDao.get(id);
            return p;
        }catch (FollowupException e){
            throw new FollowupException("无");
        }
    }
}
