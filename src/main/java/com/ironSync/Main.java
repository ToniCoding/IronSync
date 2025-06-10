package com.ironSync;

import com.ironSync.controller.UserController;
import com.ironSync.model.WorkoutEntry;
import com.ironSync.storage.FileManager;

public class Main {
    private static final FileManager fileHandler = new FileManager();
    public static void main(String[] args) {
        UserController userController = new UserController();
        //System.out.println(userController.createNewWorkoutEntry());
        WorkoutEntry createdWorkoutEntry = userController.createNewWorkoutEntry();
        fileHandler.registerData(createdWorkoutEntry);
    }
}
