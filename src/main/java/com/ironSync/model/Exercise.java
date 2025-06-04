package com.ironSync.model;

/**
 * Represents an exercise, including its name, the primary muscle group it targets,
 * and a description.
 */
public class Exercise {
    private String name;
    private String muscleGroup;
    private String description;

    /**
     * Default constructor.
     * Creates an Exercise object with no initial values.
     */
    public Exercise() {
    }

    /**
     * Full constructor.
     *
     * @param name         The name of the exercise.
     * @param muscleGroup  The primary muscle group targeted by the exercise.
     * @param description  A description of the exercise.
     */
    public Exercise(String name, String muscleGroup, String description) {
        this.name = name;
        this.muscleGroup = muscleGroup;
        this.description = description;
    }

    /**
     * Gets the name of the exercise.
     *
     * @return The exercise name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the muscle group targeted by the exercise.
     *
     * @return The muscle group.
     */
    public String getMuscleGroup() {
        return this.muscleGroup;
    }

    /**
     * Gets the description of the exercise.
     *
     * @return The description.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the name of the exercise.
     *
     * @param name The new name of the exercise.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the primary muscle group of the exercise.
     *
     * @param muscleGroup The new muscle group.
     */
    public void setMuscleGroup(String muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

    /**
     * Sets the description of the exercise.
     *
     * @param description The new description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns a string representation of the Exercise object.
     *
     * @return A formatted string with the exercise details.
     */
    @Override
    public String toString() {
        return "Exercise {" +
                "name = " + name +
                ", muscleGroup = " + muscleGroup +
                ", description = " + description +
                "}";
    }
}
