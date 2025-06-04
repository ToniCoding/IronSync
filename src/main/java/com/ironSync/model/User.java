package com.ironSync.model;

/**
 * Represents a user in the system, containing personal information such as their unique identifier,
 * username, password, level, experience, and streak.
 */
public class User {
    private int uniqueId;
    private String username;
    private String password;
    private int level;
    private int experience;
    private int streak;

    /**
     * Default constructor.
     * Creates a User object without initializing its fields.
     */
    public User() {

    }

    /**
     * Constructor with parameters to initialize a User object with all its attributes.
     *
     * @param uniqueId   The unique identifier of the user.
     * @param username   The username.
     * @param password   The user's password.
     * @param level      The user's level.
     * @param experience The user's experience.
     * @param streak     The user's training streak.
     */
    public User(int uniqueId, String username, String password, int level, int experience, int streak) {
        this.uniqueId = uniqueId;
        this.username = username;
        this.password = password;
        this.level = level;
        this.experience = experience;
        this.streak = streak;
    }

    /**
     * Gets the unique identifier of the user.
     *
     * @return The unique identifier.
     */
    public int getUniqueId() {
        return uniqueId;
    }

    /**
     * Gets the username.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the user's password.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the user's level.
     *
     * @return The user's level.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Gets the accumulated experience of the user.
     *
     * @return The user's experience.
     */
    public int getExperience() {
        return experience;
    }

    /**
     * Gets the user's training streak.
     *
     * @return The training streak.
     */
    public int getStreak() {
        return streak;
    }

    /**
     * Sets the unique identifier of the user.
     *
     * @param uniqueId The new unique identifier.
     */
    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    /**
     * Sets the username.
     *
     * @param username The new username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets the user's password.
     *
     * @param password The new password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the user's level.
     *
     * @param level The new level.
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Sets the user's training streak.
     *
     * @param streak The new training streak.
     */
    public void setStreak(int streak) {
        this.streak = streak;
    }

    /**
     * Sets the user's experience.
     *
     * @param experience The new amount of experience.
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }

    /**
     * Returns a string representation of the User object.
     *
     * @return A string with the user's details.
     */
    @Override
    public String toString() {
        return "User {" +
                "UniqueId = " + uniqueId +
                ", username = " + username +
                ", level = " + level +
                ", streak = " + streak +
                ", experience = " + experience +
                "}";
    }
}
