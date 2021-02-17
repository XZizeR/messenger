package com.nick.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nick.repository.EventMongoRepositoryImpl;
import com.nick.repository.EventRedisRepository;
import com.nick.model.Event;


public class EventDAO {
	@Autowired
	private EventMongoRepositoryImpl mongoRepo;
	@Autowired
	private EventRedisRepository redisRepo;
	
	public void fromMongoToRedis() {
		List<Event> events = mongoRepo.getEvents();
		for (Event ev : events) {
			redisRepo.save(ev);
		}
	}

}
