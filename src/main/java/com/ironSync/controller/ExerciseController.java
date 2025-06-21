package com.ironSync.controller;

import com.ironSync.model.Exercise;
import com.ironSync.data.ExercisesLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * This class manages operations related to exercises.
 * It provides methods to load exercises, extract exercise data based on a requested name,
 * and build an Exercise object with the relevant data.
 */
public class ExerciseController {

    /**
     * Loads a list of default exercises by calling the ExercisesLoader.
     *
     * @return A List of Exercise objects loaded from the default data source.
     */
    public List<Exercise> loadExercises() {
        return ExercisesLoader.loadDefaultExercises();
    }

    /**
     * Extracts data for a specific exercise based on its name.
     * The data returned includes the exercise's name, description, and muscle group.
     *
     * @param requestedExerciseData The name of the exercise whose data is to be extracted.
     * @return A List of Strings containing the name, description, and muscle group of the requested exercise.
     */
    public List<String> extractExerciseData(String requestedExerciseData) {
        List<Exercise> exercisesList = loadExercises();
        List<String> exerciseDataExtractList = new ArrayList<>();

        for (Exercise exercise : exercisesList) {
            if (exercise.getName().equals(requestedExerciseData)) {
                exerciseDataExtractList.addAll(List.of(
                        exercise.getName(),
                        exercise.getMuscleGroup(),
                        exercise.getDescription()));
            }
        }

        return exerciseDataExtractList;
    }

    /**
     * Builds an Exercise object using the name of an exercise.
     * The Exercise object is constructed using the extracted data (name, description, and muscle group).
     *
     * @param exerciseDone The name of the exercise to be built into an Exercise object.
     * @return A new Exercise object containing the data corresponding to the requested exercise.
     */
    public Exercise exerciseBuilder(String exerciseDone) {
        List<String> exerciseData = extractExerciseData(exerciseDone);

        if (exerciseData.isEmpty()) {
            throw new IllegalArgumentException("The selected exercise does not exist.");
        }

        return new Exercise(exerciseData.get(0), exerciseData.get(1), exerciseData.get(2));
    }
}
