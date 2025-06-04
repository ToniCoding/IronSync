package com.ironSync.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * A utility class for serializing objects into JSON format.
 * It provides a method to convert any object to its JSON string representation.
 */
public class ObjectUtils {

    /**
     * Serializes the given object into a JSON string.
     *
     * @param object The object to be serialized into JSON format.
     * @return The JSON string representation of the provided object.
     * @throws RuntimeException if there is an error during serialization or an unhandled exception occurs.
     */
    public String objectSerialization(Object object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializing object to JSON - More details: \n", e);
        } catch (Exception e) {
            throw new RuntimeException("An unhandled exception happened - More details: \n", e);
        }
    }
}
