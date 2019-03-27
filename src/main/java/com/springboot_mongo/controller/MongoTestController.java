package com.springboot_mongo.controller;

import com.springboot_mongo.dao.MongoTestDao;
import com.springboot_mongo.pojo.MongoTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MongoTestController {
    @Autowired
    private MongoTestDao mtdao;

    @GetMapping(value = "test1")
    public void saveTest(){
        MongoTest test=new MongoTest();
        test.setId(1);
        test.setAge(20);
        test.setName("Test");
        mtdao.saveTest(test);
    }

    @GetMapping(value = "test2")
    public MongoTest findTestByName(){
        MongoTest test=mtdao.findTestByName("Test");
        System.out.println(test);
        return test;
    }

    
}
