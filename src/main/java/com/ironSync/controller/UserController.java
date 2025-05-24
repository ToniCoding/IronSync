package main.java.com.ironSync.controller;

import main.java.com.ironSync.model.Workout;
import main.java.com.ironSync.model.WorkoutEntry;
import main.java.com.ironSync.util.UserInputs;
import main.java.com.ironSync.util.ParseDate;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private final UserInputs userInputs = new UserInputs();
    private final ParseDate dateParser = new ParseDate();

    public WorkoutEntry createNewWorkoutEntry() {
        String exerciseDone = userInputs.promptText("Introduce the name of the exercise done:");
        List<Integer> numberOfReps = userInputs.repetitionsStringToIntegerList(userInputs.promptText("Introduce the number of repetitions done:"));
        int numberOfSets = userInputs.promptInt("Introduce the number of sets done:");

        return new WorkoutEntryController().workoutEntryBuilder(exerciseDone, numberOfReps, numberOfSets);
    }

    public List<WorkoutEntry> buildWorkoutEntryList() {
        List<WorkoutEntry> workoutEntries = new ArrayList<WorkoutEntry>();
        
        while (true) {
            workoutEntries.add(createNewWorkoutEntry());

            System.out.println("Do you want to add another workout entry? ");
            String userDecision = userInputs.promptTextWithOptions("Do you want to add another workout entry? (Y/n)", "y,n");

            if (userInputs.processUserInputFromTwoOptions("y,n", userDecision)) {
                return workoutEntries;
            }
        }
    }

    public Workout createNewWorkout(List<WorkoutEntry> workoutEntries) {
        String workoutTitle = userInputs.promptText("Introduce the name of the workout: ");
        String workoutNotes = userInputs.promptText("Introduce the notes for the workout: ");

        return new WorkoutController().workoutBuilder(workoutEntries, workoutTitle, workoutNotes, dateParser.getCurrentDateTimeFormatted(1));
    }
}
