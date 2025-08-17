package com.ironSync.repository;

import com.ironSync.model.User;

public interface UserRepositoryIntf {
    boolean create(User user);
    boolean userLevelEdit(User user, String editableField, String newValue);
}
