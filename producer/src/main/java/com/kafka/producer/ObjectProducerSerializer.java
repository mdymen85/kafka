package com.kafka.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

public class ObjectProducerSerializer implements Serializer {

    @Override
    public byte[] serialize(String s, Object o) {
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            retVal = objectMapper.writeValueAsString(o).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }

}
