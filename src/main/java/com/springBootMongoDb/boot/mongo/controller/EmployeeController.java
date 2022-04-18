package com.springBootMongoDb.boot.mongo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBootMongoDb.boot.mongo.EmployeeModel;

import org.springframework.data.mongodb.core.MongoTemplate;

@RestController
@RequestMapping(value = "/template")
public class EmployeeController {
	private final Logger logger = LoggerFactory.getLogger(getClass());

    private final MongoTemplate mongoTemplate;

    public EmployeeController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List < EmployeeModel > getAllUsers() {
        logger.info("Getting all Employees.");
        return mongoTemplate.findAll(EmployeeModel.class);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public EmployeeModel getEmployee(@PathVariable long id) {
        logger.info("Getting Employee with ID: {}.", id);
        EmployeeModel employeeModel = mongoTemplate.findById(id, EmployeeModel.class);
        return employeeModel;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public EmployeeModel add(@RequestBody EmployeeModel employeeModel) {
        logger.info("Saving Employee.");
        return mongoTemplate.save(employeeModel);
    }
    
    @RequestMapping("/welcome")
    public String welcome() {
    	String text = "this is private page";
    	return text;
    }

}
