package com.kafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "topic3", groupId = "foo")
    public void listenGroupFoo(Person person) {
        log.info("Person {}", person);
    }

}
