package main.java.com.ironSync.controller;

import main.java.com.ironSync.model.Workout;
import main.java.com.ironSync.model.WorkoutEntry;

import java.util.List;

public class WorkoutController {
    public Workout workoutBuilder(List<WorkoutEntry> workoutEntries, String workoutTitle, String workoutNotes, String workoutDate) {
        return new Workout(workoutEntries, workoutTitle, workoutNotes, workoutDate);
    }
}
