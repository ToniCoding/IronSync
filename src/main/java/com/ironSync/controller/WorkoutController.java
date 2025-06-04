package com.ironSync.controller;

import com.ironSync.model.Workout;
import com.ironSync.model.WorkoutEntry;

import java.util.List;

/**
 * Controller responsible for creating Workout objects.
 */
public class WorkoutController {

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
        return new Workout(workoutEntries, workoutTitle, workoutNotes, workoutDate);
    }
}
