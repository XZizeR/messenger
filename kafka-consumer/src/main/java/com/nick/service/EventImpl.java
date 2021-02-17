package com.nick.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.nick.model.Event;
import com.nick.repository.EventMongoRepository;

@Service
public class EventImpl {
	
	@Autowired
	private EventMongoRepository repo;
	
	@KafkaListener(topics="Events", groupId ="group_json", containerFactory="eventKafkaListenerContainerFactory")
	public void consumeJson(Event event) {
		addToMongo(event);
		System.out.println(event);
	}
	
	public void addToMongo(Event event) {
		repo.save(event);
    }
	
}
