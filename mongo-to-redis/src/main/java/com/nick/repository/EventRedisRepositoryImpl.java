package com.nick.repository;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.nick.model.Event;

@Repository
public class EventRedisRepositoryImpl implements EventRedisRepository{

	private RedisTemplate<String, Event> redisTemplate;
	private HashOperations<String, Integer, Event> hashOperations;
	
	public EventRedisRepositoryImpl(RedisTemplate<String, Event> redisTemplate) {
		this.redisTemplate = redisTemplate;
		hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public void save(Event event) {
		hashOperations.put("Event", event.getReporterId(), event);
		
	}

}
