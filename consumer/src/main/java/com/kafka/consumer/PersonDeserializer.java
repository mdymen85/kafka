package com.kafka.consumer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class PersonDeserializer implements Deserializer<Person> {

    @Override
    public Person deserialize(String s, byte[] bytes) {
        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Person person = null;
        try {
            person = mapper.readValue(bytes, Person.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return person;
    }

}
