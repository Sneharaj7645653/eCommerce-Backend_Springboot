package com.example.eCommerce.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DatabaseService {

    private final MongoTemplate mongoTemplate;

    public void dropDatabase() {
        mongoTemplate.getDb().drop();
    }
}
