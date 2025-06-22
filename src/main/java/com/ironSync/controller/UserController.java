package com.ironSync.controller;

import com.ironSync.model.Workout;
import com.ironSync.util.ParseDate;
import com.ironSync.model.WorkoutEntry;
import com.ironSync.util.UserInputs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Handles user interactions related to workouts and workout entries.
 * This controller gathers user input and constructs domain objects such as Workout and WorkoutEntry.
 */
public class UserController {
    private final Scanner scanner = new Scanner(System.in);
    private final UserInputs userInputs = new UserInputs();
    private final ParseDate dateParser = new ParseDate();

    /**
     * Prompts the user to input data for a single workout entry and returns a new WorkoutEntry object.
     * Ensures that the exercise name is unique within the current workout.
     *
     * @param workoutEntries The list of workout entries already created, used to avoid duplicates
     * @return A new WorkoutEntry created from user input
     */
    public WorkoutEntry createNewWorkoutEntry(List<WorkoutEntry> workoutEntries) {
        String exerciseDone = userInputs.promptText("Introduce the name of the exercise done:");

        Set<String> existingExerciseNames = workoutEntries.stream()
                .map(entry -> entry.getExercise().getName())
                .collect(Collectors.toSet());

        while (existingExerciseNames.contains(exerciseDone)) {
            System.out.println("This exercise is already in the workout.");
            exerciseDone = userInputs.promptText("Introduce the name of the exercise done:");
        }

        List<Integer> repsPerSet = userInputs.repetitionsStringToIntegerList(
                userInputs.promptText("Introduce the number of repetitions done:"));
        int numberOfSets = repsPerSet.size();

        return new WorkoutEntryController().workoutEntryBuilder(exerciseDone, repsPerSet, numberOfSets);
    }

    /**
     * Prompts the user to create multiple workout entries in sequence.
     * Continues to prompt until the user chooses to stop.
     *
     * @return A list of WorkoutEntry objects collected from user input
     */
    public List<WorkoutEntry> buildWorkoutEntryList() {
        List<WorkoutEntry> workoutEntries = new ArrayList<>();

        while (true) {
            workoutEntries.add(createNewWorkoutEntry(workoutEntries));

            userInputs.promptTextWithOptions("Do you want to add another workout entry? (Y/n)", "y,n");

            String userDecision = scanner.nextLine();

            if (!userInputs.processUserInputFromTwoOptions("y,n", userDecision)) {
                return workoutEntries;
            }
        }
    }

    /**
     * Collects user input to build a complete Workout object.
     * This includes the workout title, notes, list of entries, and the current date and time.
     *
     * @return A new Workout object based on user input
     */
    public Workout createNewWorkout() {
        String workoutTitle = userInputs.promptText("Introduce the name of the workout: ");
        String workoutNotes = userInputs.promptText("Introduce the notes for the workout: ");
        List<WorkoutEntry> workoutEntries = this.buildWorkoutEntryList();

        return new WorkoutController().workoutBuilder(
                workoutEntries,
                workoutTitle,
                workoutNotes,
                dateParser.getCurrentDateTimeFormatted(1)
        );
    }
}
