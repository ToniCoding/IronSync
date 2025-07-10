package com.ironSync.helpers;

import com.ironSync.data.ExercisesLoader;
import com.ironSync.model.Exercise;
import com.ironSync.util.UserInputs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages the available exercises and provides utility methods
 * to normalize exercise names and retrieve them.
 */
public class ExerciseManager {
    private final UserInputs userInputs = new UserInputs();
    private final Map<String, Exercise> exerciseMap = new HashMap<>();

    /**
     * Constructs the ExerciseManager and loads default exercises
     * into a map using their normalized names as keys.
     */
    public ExerciseManager() {
        List<Exercise> exercises = ExercisesLoader.loadDefaultExercises();

        for (Exercise exercise : exercises) {
            String normalized = userInputs.removeIntermediateWhitespaceCharacters(exercise.getName());
            exerciseMap.put(normalized, exercise);
        }
    }

    /**
     * Checks if an exercise with the given normalized name exists.
     *
     * @param normalizedName The normalized exercise name.
     * @return True if the exercise exists, false otherwise.
     */
    public boolean exerciseExists(String normalizedName) {
        return exerciseMap.containsKey(normalizedName);
    }

    /**
     * Retrieves the Exercise object associated with the given normalized name.
     *
     * @param normalizedName The normalized exercise name.
     * @return The corresponding Exercise object, or null if not found.
     */
    public Exercise getExercise(String normalizedName) {
        return exerciseMap.get(normalizedName);
    }
}
