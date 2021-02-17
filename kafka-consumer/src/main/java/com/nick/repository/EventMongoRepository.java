package com.nick.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nick.model.Event;

public interface EventMongoRepository extends MongoRepository<Event, Integer>{}
