package com.springBootMongoDb.boot.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.User;

public interface UserRepo extends MongoRepository<User, Integer> {
    public User findByUsername(String username);

}
