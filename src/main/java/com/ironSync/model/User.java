package com.ironSync.model;

/**
 * Represents a user in the system, containing personal information such as their unique identifier,
 * username, password, level, experience, and streak.
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String role;
    private String status;
    private String alias;
    private int age;
    private int weight;
    private int height;
    private int experience;
    private int streak;
    private int days_trained;

    /**
     * Default constructor.
     * Creates a User object without initializing its fields.
     */
    public User() {

    }

    /**
     * Constructor with parameters to initialize a User object with all its attributes.
     *
     * @param id   The unique identifier of the user.
     * @param username   The username.
     * @param password   The user's password.
     * @param email      The user's email.
     * @param alias      The user's alias.
     * @param experience The user's experience.
     * @param streak     The user's training streak.
     */
    public User(int id, String username, String password, String email, String alias, int experience, int streak) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.alias = alias;
        this.experience = experience;
        this.streak = streak;
    }

    /**
     * Gets the unique identifier of the user.
     *
     * @return The unique identifier.
     */
    public int getId() {
        return id;
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
     * Gets the user email
     *
     * @return The user email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the user role
     *
     * @return The user role.
     */
    public String getRole() {
        return role;
    }

    /**
     * Gets the user status
     *
     * @return The user status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Gets the user alias
     *
     * @return The user alias.
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Gets the user age
     *
     * @return The user age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Gets the user weight
     *
     * @return The user weight.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Gets the user height
     *
     * @return The user height.
     */
    public int getHeight() {
        return height;
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
     * Gets the user's trained days.
     *
     * @return The trained days.
     */
    public int getDays_trained() {
        return this.days_trained;
    }

    /**
     * Sets the unique identifier of the user.
     *
     * @param id The new unique identifier.
     */
    public void setId(int id) {
        this.id = id;
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
     * Sets the user email.
     *
     * @param email The new amount of email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the user role.
     *
     * @param role The new user's role.
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Sets the user status.
     *
     * @param status The new user's status.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Sets the user alias.
     *
     * @param alias The new user's alias.
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * Sets the user age.
     *
     * @param age The new user's age.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Sets the user weight.
     *
     * @param weight The new amount of weight.
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Sets the user height.
     *
     * @param height The new amount of height.
     */
    public void setHeight(int height) {
        this.height = height;
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
     * Sets the user's trained days.
     *
     * @param daysTrained The new amount of trained days.
     */
    public void setDaysTrained(int daysTrained) {
        this.days_trained = daysTrained;
    }

    /**
     * Returns a string representation of the User object.
     *
     * @return A string with the user's details.
     */
    @Override
    public String toString() {
        return "User {" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                ", alias='" + alias + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                ", experience=" + experience +
                ", streak=" + streak +
                ", days_trained=" + days_trained +
                '}';
    }

}
