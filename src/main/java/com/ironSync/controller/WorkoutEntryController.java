package main.java.com.ironSync.controller;

import main.java.com.ironSync.model.Exercise;
import main.java.com.ironSync.model.WorkoutEntry;

import java.util.List;

public class WorkoutEntryController {
    public Exercise getExerciseDetails(String exerciseDone) {
        ExerciseController exController = new ExerciseController();

        return exController.exerciseBuilder(exerciseDone);
    }

    public boolean verifyRepetitionsLength(List<Integer> numberOfReps, int numberOfSets) {
        return numberOfReps.size() == numberOfSets;
    }

    public WorkoutEntry workoutEntryBuilder (String exerciseDone, List<Integer> nReps, int nSets) {
        if (!verifyRepetitionsLength(nReps, nSets)) {
            throw new IllegalArgumentException("Length of repetitions list must match number of sets.");
        }

        return new WorkoutEntry(getExerciseDetails(exerciseDone), nReps, nSets);
    }
}
