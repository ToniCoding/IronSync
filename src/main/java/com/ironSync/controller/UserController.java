package com.ironSync.controller;

import com.ironSync.model.Workout;
import com.ironSync.util.ParseDate;
import com.ironSync.model.WorkoutEntry;
import com.ironSync.util.UserInputs;
import com.ironSync.helpers.ExerciseManager;

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
    private final ExerciseManager exerciseManager = new ExerciseManager();

    /**
     * Prompts the user to input data for a single workout entry and returns a new WorkoutEntry object.
     * This method ensures:
     * - The exercise entered by the user exists in the system's exercise database.
     * - The exercise is not already included in the current workout to avoid duplicates.
     * - Repetitions are requested from the user and the number of sets is calculated automatically.
     * It continues prompting the user until a valid, existing, and unique exercise is provided.
     *
     * @param workoutEntries The list of workout entries already created, used to check for duplicates.
     * @return A new WorkoutEntry created from validated user input.
     */
    public WorkoutEntry createNewWorkoutEntry(List<WorkoutEntry> workoutEntries) {
        Set<String> existingExerciseNames = workoutEntries.stream()
                .map(entry -> entry.getExercise().getName())
                .collect(Collectors.toSet());

        while (true) {
            String exerciseDone = userInputs.removeIntermediateWhitespaceCharacters(
                    userInputs.promptText("Introduce the name of the exercise done:"));

            if (!exerciseManager.exerciseExists(exerciseDone)) {
                System.out.print("The introduced exercise does not exist.\n");
                continue;
            }

            if (existingExerciseNames.contains(exerciseDone)) {
                System.out.print("The introduced exercise is already in the workout.\n");
                continue;
            }

            List<Integer> repsPerSet = userInputs.repetitionsStringToIntegerList(
                    userInputs.promptText("Introduce the number of repetitions done:"));
            int numberOfSets = repsPerSet.size();

            return new WorkoutEntryController().workoutEntryBuilder(exerciseDone, repsPerSet, numberOfSets);
        }
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
            try {
                workoutEntries.add(createNewWorkoutEntry(workoutEntries));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

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
                dateParser.getCurrentDateAndTimeFormatted(3),
                dateParser.getCurrentDateAndTimeFormatted(4)
        );
    }
}
