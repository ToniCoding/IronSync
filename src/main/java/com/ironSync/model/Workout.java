package main.java.com.ironSync.model;

import main.java.com.ironSync.config.AppConstants;

import java.util.List;

/**
 * Represents a full workout session, including the workout entry (exercise, reps, sets),
 * training notes, and the date of the workout.
 */
public class Workout {
    private List<WorkoutEntry> workoutEntries;
    private String trainingTitle;
    private String trainingNotes;
    private String trainingDate;

    /**
     * Default constructor.
     */
    public Workout() {
    }

    /**
     * Constructs a Workout with the specified workout entries, notes, and date.
     *
     * @param workoutEntries  The list of workout entries of the current session.
     * @param trainingTitle The title of the training session.
     * @param trainingNotes The notes about the training session.
     * @param trainingDate  The date the workout took place.
     */
    public Workout(List<WorkoutEntry> workoutEntries, String trainingTitle, String trainingNotes, String trainingDate) {
        if (workoutEntries.isEmpty()) {
            throw new IllegalArgumentException("There are no registered exercises in the workout.");
        }

        if (!trainingTitle.isEmpty() && trainingTitle.length() <= AppConstants.SESSION_TITLE_MAX_CHARACTERS) {
                throw new IllegalArgumentException("Training title can not be empty or longer than " + AppConstants.SESSION_TITLE_MAX_CHARACTERS);
        }

        if (!trainingNotes.isEmpty() && trainingNotes.length() <= AppConstants.SESSION_NOTES_MAX_CHARACTERS) {
            throw new IllegalArgumentException("Training notes can not be empty or longer than" + AppConstants.SESSION_NOTES_MAX_CHARACTERS);
        }

        this.workoutEntries = workoutEntries;
        this.trainingTitle = trainingTitle;
        this.trainingNotes = trainingNotes;
        this.trainingDate = trainingDate;
    }

    /**
     * Gets the workout entry.
     *
     * @return The WorkoutEntry object.
     */
    public List<WorkoutEntry> getWorkoutEntries() {
        return this.workoutEntries;
    }

    /**
     * Gets the training title.
     *
     * @return A string containing the training title.
     */
    public String getTrainingTitle() {
        return this.trainingTitle;
    }

    /**
     * Gets the training notes.
     *
     * @return A string containing the training notes.
     */
    public String getTrainingNotes() {
        return this.trainingNotes;
    }

    /**
     * Gets the training date.
     *
     * @return A string containing the training date.
     */
    public String getTrainingDate() {
        return this.trainingDate;
    }

    /**
     * Sets the workout entry.
     *
     * @param workoutEntries The WorkoutEntry to set.
     */
    public void setWorkoutEntry(List<WorkoutEntry> workoutEntries) {
        this.workoutEntries = workoutEntries;
    }

    /**
     * Sets the training title.
     *
     * @param trainingTitle The notes to set.
     */
    public void setTrainingTitle(String trainingTitle) {
        this.trainingTitle = trainingTitle;
    }

    /**
     * Sets the training notes.
     *
     * @param trainingNotes The notes to set.
     */
    public void setTrainingNotes(String trainingNotes) {
        this.trainingNotes = trainingNotes;
    }

    /**
     * Sets the training date.
     *
     * @param trainingDate The date to set.
     */
    public void setTrainingDate(String trainingDate) {
        this.trainingDate = trainingDate;
    }

    /**
     * Returns a string representation of the Workout object.
     *
     * @return A formatted string with the workout details.
     */
    @Override
    public String toString() {
        return "Workout {" +
                "workoutEntry = " + workoutEntries +
                ", trainingNotes = " + trainingNotes +
                ", trainingDate = " + trainingDate +
                "}";
    }
}
