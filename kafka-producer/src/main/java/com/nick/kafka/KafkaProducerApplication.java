package com.nick.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nick.kafka.job.EventReportJob;

@SpringBootApplication
public class KafkaProducerApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(KafkaProducerApplication.class, args);
		EventReportJob eventController = ctx.getBean(EventReportJob.class);
		Thread thread = new Thread(eventController);
		thread.start();
	}

}
