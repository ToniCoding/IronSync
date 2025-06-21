package com.ironSync.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ironSync.model.Workout;
import com.ironSync.model.WorkoutEntry;

import java.util.List;

public class WorkoutDTO {
    private String name;
    private String notes;
    private String date;
    private String time;

    @JsonProperty("WorkoutEntries")
    private List<WorkoutEntry> workoutEntries;

    public WorkoutDTO (Workout workout) {
        this.name = workout.getTrainingTitle();
        this.time = workout.getTrainingNotes();
        this.date = workout.getTrainingDate();
        this.workoutEntries = workout.getWorkoutEntries();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<WorkoutEntry> getWorkoutEntries() {
        return workoutEntries;
    }

    public void setWorkoutEntries(List<WorkoutEntry> workoutEntries) {
        this.workoutEntries = workoutEntries;
    }
}
