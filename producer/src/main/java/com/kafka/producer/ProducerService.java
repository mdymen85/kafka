package com.kafka.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

	@Value("${topic.name:topic3}")
	private String topic;
	
	@Autowired
	private KafkaTemplate<Long, ObjectProducer> kafkaTemplate;
	
	@Autowired
	private KafkaTemplate<Long, String> kafkaTemplate1;
	
	public void send(ObjectProducer producer) {



		//var record = new ProducerRecord<String, ObjectProducer>(topic, producer);

		kafkaTemplate.send(topic, producer);

		//kafkaTemplate1.send(topic, producer.getName());
	}
	
}
