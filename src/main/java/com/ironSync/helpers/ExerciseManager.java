package com.ironSync.helpers;

import com.ironSync.util.UserInputs;

public class ExerciseManager {
    private final UserInputs userInputs = new UserInputs();

    public ExerciseManager() {}

    public String normalizeExerciseName (String name) {
        return userInputs.removeIntermediateWhitespaceCharacters(name.trim()).toLowerCase().replace(" ", "_");
    }
}

