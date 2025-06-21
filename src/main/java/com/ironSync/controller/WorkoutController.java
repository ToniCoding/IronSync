package com.ironSync.controller;

import com.ironSync.dto.WorkoutDTO;
import com.ironSync.model.Workout;
import com.ironSync.model.WorkoutEntry;
import com.ironSync.storage.FileManager;

import java.util.List;

/**
 * Controller responsible for creating Workout objects.
 */
public class WorkoutController {

    private final FileManager fileManager = new FileManager();

    /**
     * Builds a new {@link Workout} instance from the provided parameters.
     *
     * @param workoutEntries List of {@link WorkoutEntry} objects included in the workout.
     * @param workoutTitle   Title or name of the workout.
     * @param workoutNotes   Additional notes or comments about the workout.
     * @param workoutDate    Date of the workout as a formatted string.
     * @return A new Workout object constructed with the provided data.
     */
    public Workout workoutBuilder(List<WorkoutEntry> workoutEntries, String workoutTitle, String workoutNotes, String workoutDate) {
        Workout createdWorkout = new Workout(workoutEntries, workoutTitle, workoutNotes, workoutDate);
        WorkoutDTO workoutDTO = new WorkoutDTO(createdWorkout);
        registerWorkout(workoutDTO);

        return new Workout(workoutEntries, workoutTitle, workoutNotes, workoutDate);
    }

    public void registerWorkout(WorkoutDTO workoutDTO) {
        fileManager.registerSerializedWorkout(workoutDTO);
    }
}
