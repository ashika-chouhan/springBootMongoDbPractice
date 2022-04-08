package com.springBootMongoDb.boot.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springBootMongoDb.boot.mongo.EmployeeModel;

@Repository
public interface EmployeeRepository extends MongoRepository < EmployeeModel, Long >{

}
