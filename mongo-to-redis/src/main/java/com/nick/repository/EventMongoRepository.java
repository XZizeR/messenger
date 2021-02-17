package com.nick.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.nick.model.Event;

public interface EventMongoRepository extends MongoRepository<Event, Integer>{
	
}


