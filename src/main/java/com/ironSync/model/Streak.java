package com.ironSync.model;

import java.time.LocalDate;

public class Streak {
    private int userId;
    private int streakDays;
    private LocalDate lastTraining;

    public Streak(int id, int streakDays, LocalDate lastTraining) {
        this.userId = id;
        this.streakDays = streakDays;
        this.lastTraining = lastTraining;
    }

    public Streak() {
        this.userId = 0;
        this.streakDays = 0;
        this.lastTraining = null;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStreakDays() {
        return this.streakDays;
    }

    public void setStreakDays(int streakDays) {
        this.streakDays = streakDays;
    }

    public LocalDate getLastTraining() {
        return this.lastTraining;
    }

    public void setLastTraining(LocalDate lastTraining) {
        this.lastTraining = lastTraining;
    }
}
