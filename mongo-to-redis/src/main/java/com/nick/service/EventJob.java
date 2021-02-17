package com.nick.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nick.DAO.EventDAO;

@Component
public class EventJob implements Runnable{
	
	@Autowired
	private EventDAO eventDao;
	
	@Override
	public void run() {
		while (true) {
			try {
				eventDao.fromMongoToRedis();
				
				TimeUnit.SECONDS.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
