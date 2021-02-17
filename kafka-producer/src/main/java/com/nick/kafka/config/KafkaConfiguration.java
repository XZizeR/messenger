package com.nick.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.nick.kafka.model.Event;

@EnableKafka
@Configuration
public class KafkaConfiguration {

	@Bean
	public ProducerFactory<String, Event> producerFactory() {
		Map<String, Object> config = new HashMap<>();
		String port = "127.0.0.1:9092";

		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, port);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

		return new DefaultKafkaProducerFactory<>(config);
	}

	@Bean
	public KafkaTemplate<String, Event> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

}