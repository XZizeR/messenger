package com.nick.repository;

import com.nick.model.Event;

public interface EventRedisRepository {

	void save(Event event);
	
}
