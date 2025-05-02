package main.java.com.ironSync.storage;

import main.java.com.ironSync.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileManager {
    private String baseDirectory;
    private boolean prettyPrint;

    public static void main(String[] args) {
        try {
            User user = new User(1, "Toni", "abcd", 15, 450, 17);

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(user);

            FileManager fileManager = new FileManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
