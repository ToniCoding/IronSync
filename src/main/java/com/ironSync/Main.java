package com.ironSync;

import com.ironSync.controller.UserController;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();
        System.out.println(userController.createNewWorkoutEntry());
    }
}
