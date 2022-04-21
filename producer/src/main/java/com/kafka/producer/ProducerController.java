package com.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

	@Autowired
	private ProducerService producerService;
	
	@RequestMapping(path = "api/v1/producer", method = RequestMethod.POST)
	public void send(@RequestBody ObjectProducer producer) {
		this.producerService.send(producer);
	}
	
}
