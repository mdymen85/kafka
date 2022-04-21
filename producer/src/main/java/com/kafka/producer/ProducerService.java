package com.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

	@Value("${topic.name:quickstart}")
	private String topic;
	
	@Autowired
	private KafkaTemplate<Long, ObjectProducer> kafkaTemplate;
	
	@Autowired
	private KafkaTemplate<Long, String> kafkaTemplate1;
	
	public void send(ObjectProducer producer) {
		kafkaTemplate1.send(topic, producer.getName());
		//kafkaTemplate.send(topic, producer);
	}
	
}
