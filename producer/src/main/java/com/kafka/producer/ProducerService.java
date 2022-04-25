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
	private KafkaTemplate<String, ObjectProducer> kafkaTemplate;
	
	@Autowired
	private KafkaTemplate<Long, String> kafkaTemplate1;
	
	public void send(ObjectProducer producer) {

		//var record = new ProducerRecord<String, ObjectProducer>(topic, producer);
		int charKey = producer.getName().charAt(0);
		long key = charKey;
		kafkaTemplate.send(topic, producer.getName().substring(0,1), producer);

		//kafkaTemplate1.send(topic, producer.getName());
	}
	
}
