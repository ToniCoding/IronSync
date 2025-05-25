package main.java.com.ironSync.model;

import java.util.List;

/**
 * Represents a single entry in a workout routine, including the exercise,
 * number of repetitions, and number of sets.
 */
public class WorkoutEntry {
    private Exercise exercise;
    private List<Integer> repetitions;
    private int sets;

    /**
     * Default constructor.
     */
    public WorkoutEntry() {
    }

    /**
     * Constructs a WorkoutEntry with the given exercise, repetitions, and sets.
     *
     * @param exercise    The exercise to be performed.
     * @param repetitions Number of repetitions per set.
     * @param sets        Number of sets.
     */
    public WorkoutEntry(Exercise exercise, List<Integer> repetitions, int sets) {
        this.exercise = exercise;
        this.repetitions = repetitions;
        this.sets = sets;
    }

    /**
     * Gets the exercise of this workout entry.
     *
     * @return The associated exercise.
     */
    public Exercise getExercise() {
        return this.exercise;
    }

    /**
     * Gets the number of repetitions per set.
     *
     * @return List of numbers of repetitions for each set.
     */
    public List<Integer> getRepetitions() {
        return this.repetitions;
    }

    /**
     * Gets the number of sets.
     *
     * @return Number of sets.
     */
    public int getSets() {
        return this.sets;
    }

    /**
     * Sets the exercise for this workout entry.
     *
     * @param exercise The exercise to set.
     */
    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    /**
     * Sets the number of repetitions.
     *
     * @param repetitions The number of repetitions to set.
     */
    public void setRepetitions(List<Integer> repetitions) {
        this.repetitions = repetitions;
    }

    /**
     * Sets the number of sets.
     *
     * @param sets The number of sets to set.
     */
    public void setSets(int sets) {
        this.sets = sets;
    }

    /**
     * Returns a string representation of the Exercise object.
     *
     * @return A formatted string with the exercise entry.
     */
    @Override
    public String toString() {
        return "WorkoutEntry {" +
                "exercise = " + exercise +
                ", repetitions = " + repetitions +
                ", sets = " + sets +
                "}";
    }
}
