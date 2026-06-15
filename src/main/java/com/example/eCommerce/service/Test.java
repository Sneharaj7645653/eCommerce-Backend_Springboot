package com.example.eCommerce.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Test {

    private final MongoTemplate mongoTemplate;

    public void dropDatabase() {
        mongoTemplate.getDb().drop();
    }
}
//This code is quite dangerous to run as it will lead to the deletion of the database.
