package main.java.com.ironSync;

import main.java.com.ironSync.controller.UserController;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();
        userController.createNewWorkoutEntry();
    }
}
