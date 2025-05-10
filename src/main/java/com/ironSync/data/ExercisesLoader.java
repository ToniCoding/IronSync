package main.java.com.ironSync.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.com.ironSync.config.AppConstants;
import main.java.com.ironSync.model.Exercise;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/**
 * Class responsible for loading default exercises from a JSON file.
 */
public class ExercisesLoader {

    /**
     * Loads the default exercises from the file specified in the constant
     * {@link AppConstants#APP_DEFAULT_EXERCISES_DATA_PATH}.
     *
     * @return A list of {@link Exercise} objects representing the default exercises.
     *         If the file is not found or an error occurs, an empty list is returned.
     */
    public static List<Exercise> loadDefaultExercises() {
        try {
            ObjectMapper objMapper = new ObjectMapper();
            InputStream is = ExercisesLoader.class
                    .getClassLoader()
                    .getResourceAsStream(AppConstants.APP_DEFAULT_EXERCISES_DATA_PATH);

            if (is == null) {
                System.err.println("Could not find default_exercises.json file.");
            }

            return objMapper.readValue(is, new TypeReference<>() {});

        } catch (Exception e) {
            System.err.println("Error loading default exercises: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
