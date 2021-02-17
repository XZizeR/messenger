package com.nick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nick.service.EventJob;

@SpringBootApplication
public class MongoToRedisApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(MongoToRedisApplication.class, args);
		EventJob eventController = ctx.getBean(EventJob.class);
		Thread thread = new Thread(eventController);
		thread.start();
	}

}
