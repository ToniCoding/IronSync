package com.ironSync.helpers;

import com.ironSync.data.ExercisesLoader;
import com.ironSync.model.Exercise;
import com.ironSync.util.UserInputs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExerciseManager {
    private final UserInputs userInputs = new UserInputs();
    private final Map<String, Exercise> exerciseMap = new HashMap<>();

    public ExerciseManager() {
        List<Exercise> exercises = ExercisesLoader.loadDefaultExercises();

        for (Exercise exercise : exercises) {
            String normalized = normalizeExerciseName(exercise.getName());
            exerciseMap.put(normalized, exercise);
        }
    }

    public String normalizeExerciseName(String name) {
        return userInputs.removeIntermediateWhitespaceCharacters(name.trim()).toLowerCase().replace(" ", "_");
    }

    public boolean exerciseExists(String normalizedName) {
        return exerciseMap.containsKey(normalizedName);
    }

    public Exercise getExercise(String normalizedName) {
        return exerciseMap.get(normalizedName);
    }
}
