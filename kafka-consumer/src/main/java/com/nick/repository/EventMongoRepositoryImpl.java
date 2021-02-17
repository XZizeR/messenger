package com.nick.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import com.nick.model.Event;

@Repository
public class EventMongoRepositoryImpl {
	
	@Autowired
	private EventMongoRepository repo;
	
	@Bean
	public void addToMongo(Event event) {
		repo.save(event);
    }
}
