package main.java.com.ironSync.model;

/**
 * Represents a full workout session, including the workout entry (exercise, reps, sets),
 * training notes, and the date of the workout.
 */
public class Workout {
    private WorkoutEntry workoutEntry;
    private String trainingNotes;
    private String trainingDate;

    /**
     * Default constructor.
     */
    public Workout() {
    }

    /**
     * Constructs a Workout with the specified workout entry, notes, and date.
     *
     * @param workoutEntry  The workout entry (exercise, reps, sets).
     * @param trainingNotes The notes about the training session.
     * @param trainingDate  The date the workout took place.
     */
    public Workout(WorkoutEntry workoutEntry, String trainingNotes, String trainingDate) {
        this.workoutEntry = workoutEntry;
        this.trainingNotes = trainingNotes;
        this.trainingDate = trainingDate;
    }

    /**
     * Gets the workout entry.
     *
     * @return The WorkoutEntry object.
     */
    public WorkoutEntry getWorkoutEntry() {
        return this.workoutEntry;
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
     * @param workoutEntry The WorkoutEntry to set.
     */
    public void setWorkoutEntry(WorkoutEntry workoutEntry) {
        this.workoutEntry = workoutEntry;
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
                "workoutEntry = " + workoutEntry +
                ", trainingNotes = " + trainingNotes +
                ", trainingDate = " + trainingDate +
                "}";
    }
}
