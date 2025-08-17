package com.ironSync.repository.impl;

import com.ironSync.model.Streak;
import com.ironSync.repository.StreakRepositoryIntf;
import com.ironSync.storage.DbManager;

public class StreakRepository implements StreakRepositoryIntf {
    private final DbManager dbManager = new DbManager();

    @Override
    public boolean create(Streak streak) {
        int id = streak.getUserId();

        int returnedRows = dbManager.execUpdate(
                "INSERT INTO streak(user_id, streak_days) VALUES (?, ?)",
                id, 1
        );

        return returnedRows > 0;
    }

    @Override
    public boolean add(Streak streak, int addedDays) {
        int id = streak.getUserId();
        streak.setStreakDays(streak.getStreakDays() + addedDays);

        int rowsAffected = dbManager.execUpdate(
                "UPDATE streak SET streak_days = ? WHERE user_id = ?",
                streak.getStreakDays(), id
        );

        return rowsAffected == 1;
    }

    @Override
    public boolean reset(Streak streak) {
        int id = streak.getUserId();
        streak.setStreakDays(0);

        int rowsAffected = dbManager.execUpdate(
                "UPDATE streak SET streak_days = 0 WHERE user_id = ?",
                id
        );

        return rowsAffected == 1;
    }
}
