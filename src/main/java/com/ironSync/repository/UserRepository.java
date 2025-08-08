package com.ironSync.repository;

import com.ironSync.storage.DbManager;
import com.ironSync.model.User;

public class UserRepository {
    private final DbManager dbManager = new DbManager();

    public boolean create(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String alias = user.getAlias();
        String email = user.getEmail();
        int age = user.getAge();
        int weight = user.getWeight();
        int height = user.getHeight();

        int returnedRows = dbManager.execUpdate(
                "INSERT INTO users(username, password, email, alias, age, weight, height) VALUES (?, ?, ?, ?, ?, ?, ?)",
                username, password, email, alias, age, weight, height
        );

        if(returnedRows > 0) {
            System.out.println("Successfully created the new user.");
            return true;
        }

        return false;
    }
}
