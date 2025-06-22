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
 * Controller class responsible for handling user input related to workouts and workout entries.
 * It interacts with utility classes to gather data and creates domain objects accordingly.
 */
public class UserController {
    private final Scanner scanner = new Scanner(System.in);
    private final UserInputs userInputs = new UserInputs();
    private final ParseDate dateParser = new ParseDate();

    /**
     * Prompts the user to input details for a single workout entry
     * and creates a new {@link WorkoutEntry} object based on that data.
     *
     * @return a new WorkoutEntry created from user input
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
     * Continuously prompts the user to add workout entries until the user decides to stop.
     *
     * @return a list of WorkoutEntry objects collected from the user
     */
    public List<WorkoutEntry> buildWorkoutEntryList() {
        List<WorkoutEntry> workoutEntries = new ArrayList<>();
        List<String> exercisesIntroduced = new ArrayList<>();

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
     * Creates a new {@link Workout} object with the provided list of workout entries,
     * a workout title, and workout notes as entered by the user.
     * The current date and time is automatically assigned to the workout.
     *
     * @return a new Workout object with the specified data
     */
    public Workout createNewWorkout() {

        String workoutTitle = userInputs.promptText("Introduce the name of the workout: ");
        String workoutNotes = userInputs.promptText("Introduce the notes for the workout: ");
        List<WorkoutEntry> workoutEntries = this.buildWorkoutEntryList();

        return new WorkoutController().workoutBuilder(workoutEntries, workoutTitle, workoutNotes, dateParser.getCurrentDateTimeFormatted(1));
    }
}
