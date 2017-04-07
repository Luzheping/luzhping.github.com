package com.springboot.mongodb.mongodbTemplate.dao;

import com.mongodb.DBCollection;
import com.springboot.mongodb.mongodbTemplate.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by luzhp on 2017/4/6.
 */
@Repository
public class PersonDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void save(Person p){
        mongoTemplate.insert(p);
    }

    public void update(Person p){
        mongoTemplate.updateFirst(new Query(new Criteria("_id").is(p.getId())) ,
                new Update().set("name" , p.getName()) , Person.class);
    }

    public void delete(List<String> ids){
        ids.forEach(e->{
            System.out.println(e);
            mongoTemplate.remove(new Query(new Criteria("_id").is(e)) , Person.class);
        });
    }

    public List<Person> query(int size ,int limit){
        return mongoTemplate.find(new Query().skip(size).limit(limit) , Person.class);
    }

    public Person get(String id){
        return mongoTemplate.findById(id, Person.class);
    }

    /**
     * 统计记录条数
     * @return
     */
    public long count(){
        DBCollection Person = mongoTemplate.getCollection(mongoTemplate.getCollectionName(Person.class));
        return Person.count();
    }
}
