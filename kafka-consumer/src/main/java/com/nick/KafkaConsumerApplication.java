package com.nick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.nick.service.EventImplJob;

@SpringBootApplication
public class KafkaConsumerApplication {
	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerApplication.class, args);

//		ConfigurableApplicationContext ctx = SpringApplication.run(KafkaConsumerApplication.class, args);
//		EventConsumeJob eventController = ctx.getBean(EventConsumeJob.class);
//		Thread thread = new Thread(eventController);
//		thread.start();
	}
}
