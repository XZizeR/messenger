package com.nick.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nick.model.Event;

@Repository
public class EventMongoRepositoryImpl{
	
	@Autowired
	private EventMongoRepository repo;
	
	public List<Event> getEvents(){
		return repo.findAll();
	}
	
}
