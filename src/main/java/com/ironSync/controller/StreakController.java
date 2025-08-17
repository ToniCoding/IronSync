package com.ironSync.controller;

import com.ironSync.model.Streak;
import com.ironSync.util.NumberUtils;

public class StreakController {
    private final NumberUtils numberUtils = new NumberUtils();

    public void addStreakDays(Streak streak, int addedDays) {
        int currentStreak = streak.getStreakDays();

        if (addedDays <= 0) {
            System.out.println("You can not add less than 1 day.");
        }

        streak.setStreakDays(currentStreak + addedDays);
    }

    public void resetStreak(Streak streak) {
        streak.setStreakDays(0);
    }
}
