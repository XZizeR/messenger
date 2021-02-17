package com.nick.kafka.job;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


import com.nick.kafka.model.Event;

@Component
public class EventReportJob implements Runnable {

	@Autowired
	KafkaTemplate<String, Event> kafkaTemplate;
	private static final String TOPIC = "Events";

	@Override
	public void run() {
		while (true) {
			try {
				int reporterId = getRandomNumberUsingInts(1, 10000);
				int metricId = getRandomNumberUsingInts(1, 1000);
				int metricValue= getRandomNumberUsingInts(1, 100);


				kafkaTemplate.send(TOPIC, new Event(reporterId, new Date(), metricId, metricValue, "Event Reported"));
				
//				check
				System.out.println("Event - reportID: "+ reporterId);
				
				TimeUnit.SECONDS.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public int getRandomNumberUsingInts(int min, int max) {
		Random random = new Random();
		return random.ints(min, max).findFirst().getAsInt();
	}
}
