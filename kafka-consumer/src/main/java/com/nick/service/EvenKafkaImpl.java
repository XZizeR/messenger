package com.nick.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.nick.model.Event;
import com.nick.repository.EventMongoRepositoryImpl;

@Service
public class EvenKafkaImpl {
	
	@Autowired
	private EventMongoRepositoryImpl repo;
	
	@KafkaListener(topics="Events", groupId ="group_json", containerFactory="eventKafkaListenerContainerFactory")
	public void consumeJson(Event event) {
		repo.addToMongo(event);
		System.out.println(event);
	}
	
}
