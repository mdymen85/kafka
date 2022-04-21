package com.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

public class PersonDeserializer implements Deserializer {

    @Override
    public Object deserialize(String arg1, byte[] bytes) {
        ObjectMapper mapper = new ObjectMapper();
        Person person = null;
        try {
            person = mapper.readValue(bytes, Person.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return person;
    }

}
