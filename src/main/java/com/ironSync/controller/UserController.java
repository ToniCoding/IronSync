package main.java.com.ironSync.controller;

import main.java.com.ironSync.model.Exercise;
import main.java.com.ironSync.model.WorkoutEntry;
import main.java.com.ironSync.util.UserInputs;

import java.util.List;
import java.util.Scanner;

public class UserController {
    private final Scanner scanner = new Scanner(System.in);
    private final UserInputs userInputs = new UserInputs();

    private String promptText(String promptMessage) {
        while (true) {
            System.out.print(promptMessage + " ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (!input.isEmpty()) return input;

            System.out.println("Text cannot be empty, try again.");
        }
    }

    private int promptInt(String promptMessage) {
        while (true) {
            promptText(promptMessage);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value > 0) return value;
                System.out.println("Number must be higher than 0.");
            } catch (NumberFormatException e) {
                System.out.println("Introduce a valid number.");
            }
        }
    }

    public WorkoutEntry createNewWorkoutEntry() {
        String exerciseDone = promptText("Introduce the name of the exercise done:");
        List<Integer> numberOfReps = userInputs.repetitionsStringToIntegerList(promptText("Introduce the number of repetitions done:"));
        int numberOfSets = promptInt("Introduce the number of sets done:");

        Exercise exerciseDoneConverted = new ExerciseController().exerciseBuilder(exerciseDone);

        return new WorkoutEntry(exerciseDoneConverted, numberOfReps, numberOfSets);
    }
}
