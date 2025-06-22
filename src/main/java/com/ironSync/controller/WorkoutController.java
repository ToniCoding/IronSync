package com.ironSync.controller;

import com.ironSync.dto.WorkoutDTO;
import com.ironSync.model.Workout;
import com.ironSync.model.WorkoutEntry;
import com.ironSync.storage.FileManager;

import java.util.List;

/**
 * Controller responsible for constructing Workout objects and registering them for storage.
 */
public class WorkoutController {

    private final FileManager fileManager = new FileManager();

    /**
     * Creates a new Workout object using the provided data and registers it for storage.
     *
     * @param workoutEntries List of WorkoutEntry objects to include in the workout
     * @param workoutTitle   The title or name of the workout
     * @param workoutNotes   Optional notes or comments about the workout
     * @param workoutDate    The workout date as a formatted string
     * @return A new Workout object built with the specified data
     */
    public Workout workoutBuilder(List<WorkoutEntry> workoutEntries, String workoutTitle, String workoutNotes, String workoutDate) {
        Workout createdWorkout = new Workout(workoutEntries, workoutTitle, workoutNotes, workoutDate);
        WorkoutDTO workoutDTO = new WorkoutDTO(createdWorkout);
        registerWorkout(workoutDTO);

        return new Workout(workoutEntries, workoutTitle, workoutNotes, workoutDate);
    }

    /**
     * Registers a WorkoutDTO by serializing and saving it to persistent storage.
     *
     * @param workoutDTO The WorkoutDTO to register
     */
    public void registerWorkout(WorkoutDTO workoutDTO) {
        fileManager.registerSerializedWorkout(workoutDTO);
    }
}
