package main.java.com.ironSync.controller;

import main.java.com.ironSync.model.Workout;
import main.java.com.ironSync.model.WorkoutEntry;
import main.java.com.ironSync.util.UserInputs;
import main.java.com.ironSync.util.ParseDate;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller class responsible for handling user input related to workouts and workout entries.
 * It interacts with utility classes to gather data and creates domain objects accordingly.
 */
public class UserController {
    private final UserInputs userInputs = new UserInputs();
    private final ParseDate dateParser = new ParseDate();

    /**
     * Prompts the user to input details for a single workout entry
     * and creates a new {@link WorkoutEntry} object based on that data.
     *
     * @return a new WorkoutEntry created from user input
     */
    public WorkoutEntry createNewWorkoutEntry() {
        String exerciseDone = userInputs.promptText("Introduce the name of the exercise done:");
        List<Integer> numberOfReps = userInputs.repetitionsStringToIntegerList(
                userInputs.promptText("Introduce the number of repetitions done:"));
        int numberOfSets = userInputs.promptInt("Introduce the number of sets done:");

        return new WorkoutEntryController().workoutEntryBuilder(exerciseDone, numberOfReps, numberOfSets);
    }

    /**
     * Continuously prompts the user to add workout entries until the user decides to stop.
     *
     * @return a list of WorkoutEntry objects collected from the user
     */
    public List<WorkoutEntry> buildWorkoutEntryList() {
        List<WorkoutEntry> workoutEntries = new ArrayList<>();

        while (true) {
            workoutEntries.add(createNewWorkoutEntry());

            System.out.println("Do you want to add another workout entry? ");
            String userDecision = userInputs.promptTextWithOptions("Do you want to add another workout entry? (Y/n)", "y,n");

            if (userInputs.processUserInputFromTwoOptions("y,n", userDecision)) {
                return workoutEntries;
            }
        }
    }

    /**
     * Creates a new {@link Workout} object with the provided list of workout entries,
     * a workout title, and workout notes as entered by the user.
     * The current date and time is automatically assigned to the workout.
     *
     * @param workoutEntries list of WorkoutEntry objects to include in the workout
     * @return a new Workout object with the specified data
     */
    public Workout createNewWorkout(List<WorkoutEntry> workoutEntries) {
        String workoutTitle = userInputs.promptText("Introduce the name of the workout: ");
        String workoutNotes = userInputs.promptText("Introduce the notes for the workout: ");

        return new WorkoutController().workoutBuilder(workoutEntries, workoutTitle, workoutNotes, dateParser.getCurrentDateTimeFormatted(1));
    }
}
