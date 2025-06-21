package com.ironSync;

import com.ironSync.controller.UserController;
import com.ironSync.model.Workout;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();
        Workout createdWorkoutEntry = userController.createNewWorkout();


        System.out.println(createdWorkoutEntry);
    }
}
