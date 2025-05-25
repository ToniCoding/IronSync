package main.java.com.ironSync.controller;

import main.java.com.ironSync.model.Exercise;
import main.java.com.ironSync.model.WorkoutEntry;

import java.util.List;

/**
 * Controller class for managing WorkoutEntry creation and validation.
 */
public class WorkoutEntryController {

    /**
     * Retrieves detailed information about an exercise given its name.
     *
     * @param exerciseDone The name of the exercise performed.
     * @return An {@link Exercise} object with details of the specified exercise.
     */
    public Exercise getExerciseDetails(String exerciseDone) {
        ExerciseController exController = new ExerciseController();
        return exController.exerciseBuilder(exerciseDone);
    }

    /**
     * Verifies that the length of the repetitions list matches the number of sets.
     *
     * @param numberOfReps List containing the number of repetitions per set.
     * @param numberOfSets Total number of sets performed.
     * @return true if the list length matches the number of sets, false otherwise.
     */
    public boolean verifyRepetitionsLength(List<Integer> numberOfReps, int numberOfSets) {
        return numberOfReps.size() == numberOfSets;
    }

    /**
     * Builds a new {@link WorkoutEntry} object after validating the input data.
     * Throws an IllegalArgumentException if the length of repetitions list does not match the number of sets.
     *
     * @param exerciseDone The name of the exercise performed.
     * @param nReps       List of repetitions per set.
     * @param nSets       Number of sets performed.
     * @return A new WorkoutEntry constructed with the given parameters.
     * @throws IllegalArgumentException if repetitions list size does not match number of sets.
     */
    public WorkoutEntry workoutEntryBuilder(String exerciseDone, List<Integer> nReps, int nSets) {
        if (!verifyRepetitionsLength(nReps, nSets)) {
            throw new IllegalArgumentException("Length of repetitions list must match number of sets.");
        }
        return new WorkoutEntry(getExerciseDetails(exerciseDone), nReps, nSets);
    }
}
