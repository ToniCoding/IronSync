package com.ironSync.storage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Utility class responsible for serializing Java objects into JSON format.
 * Uses the Jackson library to convert objects to their JSON string representation.
 */
public class JsonSerializer {
    private final ObjectMapper mapper;

    /**
     * Constructs a new JsonSerializer instance with a default ObjectMapper.
     */
    public JsonSerializer() {
        this.mapper = new ObjectMapper();
    }

    /**
     * Serializes the given object into a JSON-formatted string.
     * @param serializableObject The object to serialize
     * @return A JSON string representation of the object
     * @throws RuntimeException if an error occurs during serialization
     */
    public String serialize(Object serializableObject) {
        try {
            return this.mapper.writeValueAsString(serializableObject);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("An error happened when serializing the object to JSON.");
        }
    }
}
