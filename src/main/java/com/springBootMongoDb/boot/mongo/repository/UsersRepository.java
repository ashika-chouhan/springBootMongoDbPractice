package com.springBootMongoDb.boot.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springBootMongoDb.boot.mongo.Users;

public interface UsersRepository extends MongoRepository<Users, Integer> {
    public Users findByUsername(String username);

}
