package com.ironSync.repository.impl;

import com.ironSync.repository.UserRepositoryIntf;
import com.ironSync.storage.DbManager;
import com.ironSync.model.User;

import java.util.Arrays;

public class UserRepository implements UserRepositoryIntf {
    private final DbManager dbManager = new DbManager();

    @Override
    public boolean create(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        String alias = user.getAlias();
        String email = user.getEmail();
        int age = user.getAge();
        int weight = user.getWeight();
        int height = user.getHeight();

        int returnedRows = dbManager.execUpdate(
                "INSERT INTO users(username, password, email, alias, age, weight, height, experience) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                username, password, email, alias, age, weight, height, 0
        );

        if(returnedRows > 0) {
            System.out.println("Successfully created the new user.");
            return true;
        }

        return false;
    }

    @Override
    public boolean userLevelEdit(User user, String editableField, String newValue) {
        int id = user.getId();
        String[] validFields = {"username", "password", "email", "alias", "age"};

        if (checkIfUserExists(id) && Arrays.asList(validFields).contains(editableField)) {
            dbManager.execUpdate(
                    "UPDATE users SET " + editableField + "= ? WHERE id = ?",
                    newValue, id
            );

            return true;
        }

        return false;
    }

    @Override
    public boolean delete(User user) {
        int id = user.getId();

        return checkIfUserExists(id) && dbManager.execUpdate("DELETE FROM users WHERE id = ?", id) >= 1;
    }

    private boolean checkIfUserExists(int userId) {
        return dbManager.execQuery(
                "SELECT username FROM users WHERE id = ?",
                null,
                userId
        );
    }
}
