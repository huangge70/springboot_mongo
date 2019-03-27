package com.springboot_mongo.dao;

import com.springboot_mongo.pojo.MongoTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class MongoTestDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    //新增对象
    public void saveTest(MongoTest test){
        mongoTemplate.save(test);
    }

    //查询对象
    public MongoTest findTestByName(String name){
        Query query=new Query(Criteria.where("name").is(name));
        MongoTest test=mongoTemplate.findOne(query,MongoTest.class);
        return test;
    }

    //修改对象
    public void updateTest(MongoTest test){
        Query query=new Query(Criteria.where("id").is(test.getId()));
        Update update=new Update().set("age",test.getAge()).set("name",test.getName());
        mongoTemplate.updateFirst(query,update,MongoTest.class);
    }

    //删除对象
    public void deleteTestById(Integer id){
        Query query=new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query,MongoTest.class);
    }
}
