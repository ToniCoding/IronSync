package com.ironSync.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ironSync.model.Workout;
import com.ironSync.model.WorkoutEntry;

import java.util.List;

/**
 * Data Transfer Object (DTO) that represents a Workout in a serializable form.
 * This class is used to transfer workout data, especially for persistence and external representation.
 */
public class WorkoutDTO {
    private String name;
    private String notes;
    private String date;
    private String time;

    @JsonProperty("WorkoutEntries")
    private List<WorkoutEntry> workoutEntries;

    /**
     * Constructs a WorkoutDTO from a Workout domain object.
     *
     * @param workout The Workout object to convert into a DTO
     */
    public WorkoutDTO(Workout workout) {
        this.name = workout.getTrainingTitle();
        this.notes = workout.getTrainingNotes();
        this.date = workout.getTrainingDate();
        this.workoutEntries = workout.getWorkoutEntries();
    }

    /**
     * Returns the name of the workout.
     *
     * @return Workout name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the workout.
     *
     * @param name Workout name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the notes associated with the workout.
     *
     * @return Workout notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets the workout notes.
     *
     * @param notes Workout notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Returns the date of the workout.
     *
     * @return Workout date
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the date of the workout.
     *
     * @param date Workout date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Returns the time or duration information of the workout.
     *
     * @return Workout time or duration
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the time or duration information of the workout.
     *
     * @param time Workout time or duration
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Returns the list of workout entries associated with the workout.
     *
     * @return List of WorkoutEntry objects
     */
    public List<WorkoutEntry> getWorkoutEntries() {
        return workoutEntries;
    }

    /**
     * Sets the list of workout entries.
     *
     * @param workoutEntries List of WorkoutEntry objects
     */
    public void setWorkoutEntries(List<WorkoutEntry> workoutEntries) {
        this.workoutEntries = workoutEntries;
    }
}
