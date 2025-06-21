package com.ironSync.storage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonSerializer {
    private final ObjectMapper mapper;

    public JsonSerializer() {
        this.mapper = new ObjectMapper();
    }

    public String serialize(Object serializableObject) {
        try {
            return this.mapper.writeValueAsString(serializableObject);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("An error happened when serializing the object to JSON.");
        }
    }
}
