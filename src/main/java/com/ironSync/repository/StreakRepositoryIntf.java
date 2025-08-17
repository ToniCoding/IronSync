package com.ironSync.repository;

import com.ironSync.model.Streak;
import com.ironSync.model.User;

public interface StreakRepositoryIntf {
    boolean create(Streak streak);
    boolean add(Streak streak, int addedDays);
    boolean reset(Streak streak);
}
