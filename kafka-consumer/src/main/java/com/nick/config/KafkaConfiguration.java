package com.nick.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.nick.model.Event;

@EnableKafka
@Configuration
public class KafkaConfiguration {
	
//	for json data
	@Bean
	public ConsumerFactory<String, Event> eventConsumerFactory(){
		Map<String, Object> config = new HashMap<>();
		String port = "127.0.0.1:9092";
		Object group = "group_json";
		
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, port);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, group);
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		
		return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), new JsonDeserializer<>(Event.class));
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Event> eventKafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, Event> factory = new ConcurrentKafkaListenerContainerFactory<String, Event>();
		factory.setConsumerFactory(eventConsumerFactory());
		return factory;
	}
	
}
